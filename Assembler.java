package edu.albany.mphipps;

public class Assembler {
	public Assembler() {
		// List of all of the available commands:
		// Move R1 Value
		// Add R1 R2 R3
		// Subtract R1 R2 R3
		// Multiply R1 R2 R3
		// And R1 R2 R3
		// Or R1 R2 R3
		// Xor R1 R2 R3
		// Not R1 R2 R3
		// LS R1 R2 R3
		// RS R1 R2 R3
		// Interrupt 0
		// Interrupt 1
		// Halt
		// Jump Value
		// Branch Conditional Address

	}

	public static String[] assemble(String[] commands) {
		String[] keywords;
		String[] code = new String[commands.length];
		// Loop through all Strings in commands
		for (int k = 0; k < commands.length; k++) {
			// Split the current command into an array of Keyword Strings
			keywords = commands[k].split(" ");

			// Check for Move then add opcode
			if (keywords[0].equalsIgnoreCase("Move")) {
				code[k] = "0001 ";

				// Add the register to the machine code
				int value = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(value);
				// add the last 4 bits to the machine code
				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				code[k] += " ";

				// add the value to the machine code
				value = Integer.parseInt(keywords[2]);
				temp = new longword();
				temp.set(value);

				// add the last 8 bits to the machine code
				for (int i = 0; i < 8; i++) {
					code[k] += "" + temp.getBit(7 - i).getValue();
					// Add space for consistency
					if (i == 3) {
						code[k] += " ";
					}
				}

			}
			// Check for Add then Append opcode to code string
			else if (keywords[0].equalsIgnoreCase("Add")) {
				code[k] = "1110 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Subtract")) {
				code[k] = "1111 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Multiply")) {
				code[k] = "0111 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("And")) {
				code[k] = "1000 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Or")) {
				code[k] = "1001 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Xor")) {
				code[k] = "1010 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Not")) {
				code[k] = "1011 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("RS")) {
				code[k] = "1101 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("LS")) {
				code[k] = "1100 ";

				// check for the first register
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the second register
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
				// add space for consistency
				code[k] += " ";

				// check for the final register
				register = Integer.parseInt(keywords[3].substring(1));
				temp.set(register);

				for (int i = 0; i < 4; i++) {
					code[k] += "" + temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Interrupt")) {
				if (keywords[1].equalsIgnoreCase("0")) {
					code[k] = "0010 0000 0000 0000";
				} else {
					code[k] = "0010 0000 0000 0001";
				}
			} else if (keywords[0].equalsIgnoreCase("Halt")) {
				code[k] = "0000 0000 0000 0000";
			} else if (keywords[0].equalsIgnoreCase("Jump")) {
				code[k] = "0011 ";
				int value = Integer.parseInt(keywords[1]);
				longword temp = new longword();
				temp.set(value);
				for (int i = 0; i < 12; i++) {
					code[k] += temp.getBit(11 - i).getValue();
					if (i == 3) {
						code[k] += " ";
					}
					if (i == 7) {
						code[k] += " ";
					}
				}

			} else if (keywords[0].equalsIgnoreCase("Compare")) {
				code[k] = "0100 0000 ";
				// Get Rx
				int register = Integer.parseInt(keywords[1].substring(1));
				longword temp = new longword();
				temp.set(register);
				// Add the first four bits of Rx to code String
				for (int i = 0; i < 4; i++) {
					code[k] += temp.getBit(3 - i).getValue();
				}
				// Add " " for consistency
				code[k] += " ";

				// Get Ry and repeat
				register = Integer.parseInt(keywords[2].substring(1));
				temp.set(register);
				// Add the first four bits of Ry to code String
				for (int i = 0; i < 4; i++) {
					code[k] += temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("BranchIfGreaterThan")) {
				code[k] = "0101 10";
				// Get the address to jump to
				int offSet = Integer.parseInt(keywords[1]);
				// Get Sign of offSet and add it to code string
				if (offSet < 0) {
					code[k] += "1";
				} else
					code[k] += "0";
				// Convert offSet into longword
				longword temp = new longword();
				temp.set(offSet);
				// Add the first 9 bits of temp to code[k] string
				for (int i = 8; i > -1; i--) {
					// add space for consistency
					if (i == 7) {
						code[k] += " ";
					} else if (i == 3) {
						code[k] += " ";
					}
					code[k] += temp.getBit(i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("BranchIfGreaterThanOrEqual")) {
				code[k] = "0101 11";
				// Get the address to jump to
				int offSet = Integer.parseInt(keywords[1]);
				// Get Sign of offSet and add it to code string
				if (offSet < 0) {
					code[k] += "1";
				} else
					code[k] += "0";
				// Convert offSet into longword
				longword temp = new longword();
				temp.set(offSet);
				// Add the first 9 bits of temp to code[k] string
				for (int i = 8; i > -1; i--) {
					// add space for consistency
					if (i == 7) {
						code[k] += " ";
					} else if (i == 3) {
						code[k] += " ";
					}
					code[k] += temp.getBit(i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("BranchIfEqual")) {
				code[k] = "0101 01";
				// Get the address to jump to
				int offSet = Integer.parseInt(keywords[1]);
				// Get Sign of offSet and add it to code string
				if (offSet < 0) {
					code[k] += "1";
				} else
					code[k] += "0";
				// Convert offSet into longword
				longword temp = new longword();
				temp.set(offSet);
				// Add the first 9 bits of temp to code[k] string
				for (int i = 8; i > -1; i--) {
					// add space for consistency
					if (i == 7) {
						code[k] += " ";
					} else if (i == 3) {
						code[k] += " ";
					}
					code[k] += temp.getBit(i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("BranchIfNotEqual")) {
				code[k] = "0101 00";
				// Get the address to jump to
				int offSet = Integer.parseInt(keywords[1]);
				// Get Sign of offSet and add it to code string
				if (offSet < 0) {
					code[k] += "1";
				} else
					code[k] += "0";
				// Convert offSet into longword
				longword temp = new longword();
				temp.set(offSet);
				// Add the first 9 bits of temp to code[k] string
				for (int i = 8; i > -1; i--) {
					// add space for consistency
					if (i == 7) {
						code[k] += " ";
					} else if (i == 3) {
						code[k] += " ";
					}
					code[k] += temp.getBit(i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Push")) {
				int reg = Integer.parseInt(keywords[1].substring(1));
				code[k] = "0110 0000 0000 ";
				longword temp = new longword();
				temp.set(reg);
				// Add the first four bits of temp/reg longword to code string
				for (int i = 0; i < 4; i++) {
					code[k] += temp.getBit(3 - i).getValue();
				}

			} else if (keywords[0].equalsIgnoreCase("Pop")) {
				// Same format as Push
				int reg = Integer.parseInt(keywords[1].substring(1));
				code[k] = "0110 0100 0000 ";
				longword temp = new longword();
				temp.set(reg);
				// Add the first four bits of temp/reg longword to code string
				for (int i = 0; i < 4; i++) {
					code[k] += temp.getBit(3 - i).getValue();
				}
			} else if (keywords[0].equalsIgnoreCase("Call")) {
				// Address is always positive since it jumps to a specific address, not an
				// offset on the current address
				int address = Integer.parseInt(keywords[1]);
				longword temp = new longword();
				temp.set(address);
				code[k] = "0110 10";
				// load the first 10 bits of address into the code string
				for (int i = 0; i < 10; i++) {
					if (i == 2) {
						code[k] += " ";
					} else if (i == 6) {
						code[k] += " ";
					}
					code[k] += temp.getBit(9 - i);
				}
			} else if (keywords[0].equalsIgnoreCase("Return")) {
				// No variance in the code string for return
				code[k] = "0110 1100 0000 0000";
			}
		}
		return code;
	}
}
