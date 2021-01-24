package edu.albany.mphipps;

public class longword implements ILongword {

	private bit[] longword;

	public longword() {
		longword = new bit[32];
		for (int i = 0; i < 32; i++) {
			longword[i] = new bit(0);
		}

	}

	@Override
	public String toString() {
		String returner = "";
		for (int i = 0; i < 32; i++) {
			if (i == 31) {
				returner += "" + longword[i].getValue();
			} else {
				returner += "" + longword[i].getValue() + ",";
			}
		}
		return returner;
	}

	@Override
	public bit getBit(int i) {
		// Get bit i

		if (i > -1 && i < 32) {
			return this.longword[31 - i];
		} else {
			System.out.println("Error: Invalid range (0-31) returned LSB: " + i);
			return this.longword[31];
		}

	}

	@Override
	public void setBit(int i, bit value) {
		// set bit i's value

		if (i < 32 && i > -1) {
			longword[31 - i].set(value.getValue());
		} else {
			System.out.println("Error: Invalid range (0-31): " + i);
		}
	}

	@Override
	public longword and(longword other) {
		// and two longwords, returning a third

		longword result = new longword();
		for (int i = 0; i < 32; i++) {
			bit resultBit = (bit) longword[31 - i].and(other.getBit(i));
			result.setBit(i, resultBit);
		}
		return result;
	}

	@Override
	public longword or(longword other) {
		// or two longwords, returning a third

		longword result = new longword();
		for (int i = 0; i < 32; i++) {
			bit resultBit = (bit) longword[31 - i].or(other.getBit(i));
			result.setBit(i, resultBit);
		}
		return result;
	}

	@Override
	public longword xor(longword other) {
		// xor two longwords, returning a third

		longword result = new longword();
		for (int i = 0; i < 32; i++) {
			bit resultBit = (bit) longword[31 - i].xor(other.getBit(i));
			result.setBit(i, resultBit);
		}
		return result;
	}

	@Override
	public longword not() {
		// negate this longword, creating another
		longword result = new longword();
		for (int i = 0; i < 32; i++) {
			if (longword[31 - i].getValue() == 0) {
				result.longword[31 - i].set();
			} else
				result.longword[31 - i].clear();
		}
		return result;
	}

	@Override
	public longword rightShift(int amount) {
		// right shift this longword by amount bits, creating a new longword
		longword returner = new longword();
		returner.set(this.getSigned());
		if (amount > 0) {
			for (int s = 0; s < amount; s++) {
				for (int i = 0; i < 32; i++) {
					// Starting at the end of the array, grab the previous bit and copy its value ::
					// If at start of array, replace value with 0.
					if (i == 31) {
						returner.longword[31 - i].set(0);
					} else {
						returner.longword[31 - i].set(returner.longword[30 - i].getValue());
					}
				}
			}
		} else {
			amount *= -1;

			for (int s = 0; s < amount; s++) {
				for (int i = 0; i < 32; i++) {
					// Starting at the end of the array, grab the previous bit and copy its value ::
					// If at start of array, replace value with 0.
					if (i == 31) {
						returner.longword[i].set(0);
					} else {
						returner.longword[i].set(returner.longword[i + 1].getValue());
					}
				}
			}
		}

		return returner;
	}

	@Override
	public longword leftShift(int amount) {
		// leftshift this longword by amount bits, creating a new longword
		longword returner = new longword();
		returner.set(this.getSigned());
		if (amount > 0) {
			for (int s = 0; s < amount; s++) {
				for (int i = 0; i < 32; i++) {
					// Starting at the end of the array, grab the previous bit and copy its value ::
					// If at start of array, replace value with 0.
					if (i == 31) {
						returner.longword[i].set(0);
					} else {
						returner.longword[i].set(returner.longword[i + 1].getValue());
					}
				}
			}
		} else {
			amount *= -1;

			for (int s = 0; s < amount; s++) {
				for (int i = 0; i < 32; i++) {
					// Starting at the end of the array, grab the previous bit and copy its value ::
					// If at start of array, replace value with 0.
					if (i == 31) {
						returner.longword[31 - i].set(0);
					} else {
						returner.longword[31 - i].set(returner.longword[30 - i].getValue());
					}
				}
			}
		}

		return returner;
	}

	@Override
	public long getUnsigned() {
		// returns the value of this longword as a long
		long result = 0;
		for (int i = 0; i < 32; i++) {
			result += longword[31 - i].getValue() * Math.pow(2, i);
		}
		return result;
	}

	@Override
	public int getSigned() {
		// returns the value of this longword as an int
		longword temp = new longword();
		int result = 0;

		// check if word is in 2's complement; if so, find its positive representation
		// and get the sum and negate it
		if (longword[0].getValue() == 1) {
			// loop through the rest of the word inverting all the bits
			for (int i = 0; i < 32; i++) {
				temp.getBit(i).set(this.getBit(i).not().getValue());
			}

			// add 1
			if (temp.getBit(0).getValue() == 0) {
				temp.getBit(0).set();
			} else {
				int index = 0;
				while (temp.getBit(index).getValue() == 1) {
					temp.getBit(index).clear();
					index++;
				}
				temp.getBit(index).set();
			}

			// loop through the bits and add bit.value * 2^n to result
			for (int i = 0; i < 32; i++) {
				result += temp.getBit(i).getValue() * Math.pow(2, i);
			}

			// negate the answer
			result *= -1;
		} else {
			for (int i = 0; i < 32; i++) {
				result += this.getBit(i).getValue() * Math.pow(2, i);
			}
		}

		return result;
	}

	@Override
	public void copy(longword other) {
		// copies the values of the bits from another longword into this one

		for (int i = 0; i < 32; i++) {
			this.longword[i].set(other.longword[i].getValue());
		}

	}

	@Override
	public void set(int value) {
		// set the value of the bits of this longword (used for tests)
		if (value > 0) {
			int binary[] = new int[32];
			int index = 0;
			while (value > 0) {
				binary[index++] = value % 2;
				value = value / 2;
			}

			for (int i = 0; i < 32; i++) {
				this.getBit(i).set(binary[i]);
			}
		} else if (value == 0) {
			for (int i = 0; i < 32; i++) {
				this.getBit(i).clear();
			}
		} else {
			// make value positive
			value = value * -1;

			// get the binary representation of the positive value
			int binary[] = new int[32];
			int index = 0;
			while (value > 0) {
				binary[index++] = value % 2;
				value = value / 2;
			}

			for (int i = 0; i < 32; i++) {
				this.getBit(i).set(binary[i]);
			}

			// convert to 1's compliment
			for (int i = 0; i < 32; i++) {
				this.getBit(i).set(this.getBit(i).not().getValue());
			}

			// add 1 (2's compliment)
			if (this.getBit(0).getValue() == 0) {
				this.getBit(0).set();
			} else {
				index = 0;
				while (this.getBit(index).getValue() == 1) {
					if (index == 31) {
						break;
					}
					this.getBit(index).clear();
					index++;
				}
				this.getBit(index).set();
			}

		}
	}
}
