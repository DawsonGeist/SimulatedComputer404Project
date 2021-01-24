package edu.albany.mphipps;

public class Computer {

	private bit halt;
	private Memory memory;
	private longword pc;
	private longword sp;
	private longword currentInstruction;
	private longword op1;
	private longword op2;
	private longword[] registers;
	private bit a; // 0 = LessThan 1= Greater Than
	private bit b;// 0 = not Equal 1 = Equal

	public Computer() {
		halt = new bit(0);
		memory = new Memory();
		pc = new longword();
		pc.set(0);
		sp = new longword();
		sp.set(1020);
		currentInstruction = new longword();
		currentInstruction.set(0);
		op1 = new longword();
		op2 = new longword();
		a = new bit(0);
		b = new bit(0);

		registers = new longword[16];
		for (int i = 0; i < 16; i++) {
			registers[i] = new longword();
		}
	}

	public void run() {
		while (halt.getValue() != 1) {
			currentInstruction = fetch();
			longword register = decode(currentInstruction);
			longword result = execute(currentInstruction);
			store(result, register);
		}
	}

	public longword fetch() {
		longword instruction = new longword();
		instruction = memory.read(pc);
		longword two = new longword();
		two.set(2);
		pc = rippleAdder.add(pc, two);
		return instruction;
	}

	public longword decode(longword instruction) {
		// get the registers for OP1 and OP2
		longword temp = new longword();
		longword mask = new longword();
		mask.set(15);

		// get the OpCode!
		temp = instruction.rightShift(12);
		temp = temp.and(mask);
		// HALT
		if (temp.getSigned() == 0) {
			temp.set(-1);
			return temp;
		}
		// MOVE
		else if (temp.getSigned() == 1) {
			// Get the Register
			temp = instruction.rightShift(8);
			temp = temp.and(mask);
			int register = temp.getSigned();

			// create a mask that will get the 8 bits that represent an integer
			longword eightBitMask = new longword();
			int index = 0;
			while (index < 8) {
				eightBitMask.getBit(index).toggle();
				index++;
			}

			// Get the Value
			// Check if the Value is Negative
			if (instruction.getBit(7).getValue() == 1) {
				// Store the 8 bits into the temp Longword
				temp = instruction.and(eightBitMask);

				// Continue the sign extension to get the full longword
				for (int i = 8; i < 32; i++) {
					temp.getBit(i).toggle();
				}

				// Store the negative longword into the register
				registers[register].set(temp.getSigned());
				temp.set(-2);
				return temp;
			}
			// the value is positive
			else {
				temp = instruction.and(eightBitMask);
				registers[register].set(temp.getSigned());
				temp.set(-2);
				return temp;
			}

		}
		// INTERRUPTS
		else if (temp.getSigned() == 2) {
			temp.set(-3);
			return temp;
		}
		// Jump
		else if (temp.getSigned() == 3) {
			temp.set(-4);
			return temp;
		}
		// Compare
		else if (temp.getSigned() == 4) {
			temp.set(-5);
			return temp;
		}
		// Branch(s)
		else if (temp.getSigned() == 5) {
			temp.set(-6);
			return temp;
		}
		// Push Pop Call Return
		else if (temp.getSigned() == 6) {
			temp.set(-7);
			return temp;
		}
		// ALU Operations
		else {
			// get OP1
			temp = instruction.rightShift(8);
			temp = temp.and(mask);
			op1.set(registers[temp.getSigned()].getSigned());
			temp.set(0);

			// get OP2
			temp = instruction.rightShift(4);
			temp = temp.and(mask);
			op2.set(registers[temp.getSigned()].getSigned());
			temp.set(0);

			// return the register that will store the result of the instruction
			temp = instruction.and(mask);
			return temp;
		}

	}

	public longword execute(longword opCode) {
		bit[] op = new bit[4];

		// get the opcode from the instruction
		for (int i = 0; i < 4; i++) {
			op[i] = opCode.getBit(15 - i);
		}

		longword result = new longword();
		longword mask = new longword();
		mask.set(15);

		// Check for Halt
		if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 0) {
			result.set(-1);
			return result;
		}
		// Check for Move
		else if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 0 && op[3].getValue() == 1) {
			result.set(-2);
			return result;
		}
		// Check for INTERRUPT
		else if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 1 && op[3].getValue() == 0) {
			// Interrupt 0 - Print Registers
			longword temp = new longword();
			temp = opCode.and(mask);
			if (temp.getSigned() == 0) {
				for (int i = 0; i < registers.length; i++) {
					System.out.println("R" + i + ": " + registers[i].getSigned());
				}
			}
			// Interrupt 1 - Print Memory
			else if (temp.getSigned() == 1) {
				longword mem = new longword();
				longword address = new longword();
				for (int i = 0; i < 256; i++) {
					address.set(i * 4);
					mem = memory.read(address);
					if ((i * 4) + 3 > 99) {
						System.out.println(((i * 4) + 3) + "-" + (i * 4) + ": \t" + mem.toString());
					} else
						System.out.println(((i * 4) + 3) + "-" + (i * 4) + ": \t\t" + mem.toString());

				}
			}
			result.set(-3);
			return result;
			// Check for Jump 0011
		} else if (op[0].getValue() == 0 && op[1].getValue() == 0 && op[2].getValue() == 1 && op[3].getValue() == 1) {
			// get the address to jump to
			longword newAddress = new longword();
			// load the unsigned bits from currentInstruction into newAddress
			for (int i = 0; i < 12; i++) {
				newAddress.getBit(i).set(opCode.getBit(i).getValue());
			}
			// set PC to newAddress Value
			pc.set(newAddress.getSigned());
			// set result = -4 so that nothing is stored
			result.set(-4);
			return result;
		}
		// Check for Compare 0100
		else if (op[0].getValue() == 0 && op[1].getValue() == 1 && op[2].getValue() == 0 && op[3].getValue() == 0) {
			// Create longword equivalents of Rx and Ry
			longword regX = new longword();
			longword regY = new longword();
			// load the bits of xxxx and yyyy into Rx and Ry
			for (int i = 0; i < 8; i++) {
				// xxxx values
				if (i > 3) {
					regX.setBit(i - 4, opCode.getBit(i));
				}
				// yyyy values
				else
					regY.setBit(i, opCode.getBit(i));
			}
			// Subtraction OpCode for ALU
			bit[] subtract = { new bit(1), new bit(1), new bit(1), new bit(1) };
			// Results of compare
			result = ALU.doOp(subtract, registers[regX.getSigned()], registers[regY.getSigned()]);

			// Set Bit A, B according to the value of result
			if (result.getSigned() > 0) {
				this.a.set();
				this.b.clear();
			} else if (result.getSigned() < 0) {
				this.a.clear();
				this.b.clear();
			} else {
				this.a.clear();
				this.b.set();
			}

			// Set result = -5 (for the store 'flag') and return result
			result.set(-5);
			return result;
		}
		// Check for Branch 0101
		else if (op[0].getValue() == 0 && op[1].getValue() == 1 && op[2].getValue() == 0 && op[3].getValue() == 1) {
			// check the control bits and See if they Match the instruction bits
			if (this.a.getValue() == opCode.getBit(11).getValue()
					&& this.b.getValue() == opCode.getBit(10).getValue()) {
				// Return 1 if branch should be taken
				result.set(1);
				return result;
			} else if (this.a.getValue() != opCode.getBit(11).getValue() && this.b.getValue() == 1
					&& opCode.getBit(10).getValue() == 1) {
				// If an Equals condition is met -> return 1
				result.set(1);
				return result;
			} else if (this.a.getValue() != opCode.getBit(11).getValue()) {
				// If an > or < condition is met -> return 1
				result.set(1);
				return result;
			} else {
				result.set(0);
				return result;
			}
		}
		// Check for push, Pop, Call, Return: 0110
		else if (op[0].getValue() == 0 && op[1].getValue() == 1 && op[2].getValue() == 1 && op[3].getValue() == 0) {
			// Mask the address for call
			longword callMask = new longword();
			callMask.set(1023);

			// Register
			longword temp = new longword();
			temp = opCode.and(mask);
			int register = temp.getSigned();

			// OffSet to move the stack pointer by (4 bytes)
			longword offSet = new longword();
			offSet.set(4);

			// Set return result to -6, No action will be taken during STORE
			result.set(-7);
			// Push 00
			if (opCode.getBit(11).getValue() == 0 && opCode.getBit(10).getValue() == 0) {
				memory.write(sp, registers[register]);
				sp = rippleAdder.subtract(sp, offSet);
			}
			// Pop 01
			else if (opCode.getBit(11).getValue() == 0 && opCode.getBit(10).getValue() == 1) {
				// after popping value, wipe the memory location at sp
				longword clear = new longword();
				// Adjust sp to point at most recent entry - if sp >= 1020 do nothing (end of
				// stack)
				if (sp.getSigned() < 1020) {
					sp = rippleAdder.add(sp, offSet);
					registers[register].set(memory.read(sp).getSigned());
					memory.write(sp, clear);
				} else
					System.out.println("End of Stack, Nothing to Pop!");

			}
			// Call 10
			else if (opCode.getBit(11).getValue() == 1 && opCode.getBit(10).getValue() == 0) {
				// The PC is already updated to the next instruction during FETCH
				memory.write(sp, pc);
				sp = rippleAdder.subtract(sp, offSet);
				// "Jump" to the address specified in the instruction
				pc = opCode.and(callMask);
			}
			// Return
			else if (opCode.getBit(11).getValue() == 1 && opCode.getBit(10).getValue() == 1) {
				// update the SP
				sp = rippleAdder.add(sp, offSet);
				// "Pop" the return address from the stack and "Jump" to it
				pc = memory.read(sp);
			}
			return result;
		} else {
			// load the opCode into the ALU w/ OP1 and OP2
			result = ALU.doOp(op, op1, op2);
			return result;
		}
	}

	public void store(longword result, longword register) {
		/*
		 * HALT: result = register = -1 MOVE: result = register = -2 INTERRUPT: result =
		 * register = -3 JUMP: result = register = -4 COMPARE: result = register = -5
		 * BRANCH: register = -6
		 */
		if (result.getSigned() == -1 && register.getSigned() == -1) {
			halt.set();
		} else if (result.getSigned() == -2 && register.getSigned() == -2) {

		} else if (result.getSigned() == -3 && register.getSigned() == -3) {

		} else if (result.getSigned() == -4 && register.getSigned() == -4) {

		} else if (result.getSigned() == -5 && register.getSigned() == -5) {

		} else if (register.getSigned() == -6) {
			// Check result to see if branch should be taken
			if (result.getSigned() == 1) {
				// Since the PC is updated (+2) during fetch(), we have to re-adjust the PC (-2)
				longword two = new longword();
				two.set(2);
				pc = rippleAdder.subtract(pc, two);

				// load the offSet longword with the value from currentInstruction
				longword offSet = new longword();

				// Check for negative offSet
				if (this.currentInstruction.getBit(9).getValue() == 1) {
					// load the value into offSet
					for (int i = 0; i < 32; i++) {
						if (i < 9) {
							offSet.setBit(i, this.currentInstruction.getBit(i));
						}
						// Sign Extend the rest of the longword
						else
							offSet.getBit(i).set();
					}
				} else {
					// Positive offSet
					for (int i = 0; i < 9; i++) {
						offSet.setBit(i, this.currentInstruction.getBit(i));
					}
				}
				// Increment PC by offSet
				pc = rippleAdder.add(pc, offSet);
			}
			// Stack Operations
		} else if (result.getSigned() == -7 && register.getSigned() == -7) {

		} else {
			registers[register.getSigned()].set(result.getSigned());
		}
	}

	public void preload(String[] instructions) {
		longword temp = new longword();
		longword address = new longword();
		String instruction = "";
		// loop through all of the strings
		for (int k = 0; k < instructions.length; k++) {
			// remove all spaces
			instruction = instructions[k].substring(0, 4) + instructions[k].substring(5, 9)
					+ instructions[k].substring(10, 14) + instructions[k].substring(15);
			// update Address
			address.set(k * 2);
			// loop through instruction string and set temp longword to its value
			for (int i = 0; i < 16; i++) {
				if (instruction.charAt(i) == '0') {
					temp.getBit(15 - i).clear();
				} else {
					temp.getBit(15 - i).set();
				}
			}
			// write temp to memory
			memory.write(address, temp);
		}
	}

}
