package edu.albany.mphipps;

public class Memory {

	private bit[] memory;
	// 256 x 32 bit memory

	public Memory() {
		memory = new bit[8192];
		for (int i = 0; i < 8192; i++) {
			memory[i] = new bit(0);
		}
	}

	public longword read(longword address) {
		longword result = new longword();
		int startingBit = address.getSigned() * 8;
		int index = 0;
		for (int i = startingBit; i < (startingBit + 32); i++) {
			result.getBit(index).set(memory[i].getValue());
			index++;
		}
		return result;
	}

	public void write(longword address, longword value) {
		if (address.getSigned() > 1020 || address.getSigned() < 0) {
			System.out.println("Error: Invalid Byte Address in Memory(0-1020): " + address.getSigned());
		} else {
			int startingBit = address.getSigned() * 8;
			int index = 0;
			for (int i = startingBit; i < (startingBit + 32); i++) {
				memory[i].set(value.getBit(index).getValue());
				index++;
			}
		}
	}

}
