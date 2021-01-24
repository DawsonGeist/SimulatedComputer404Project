package edu.albany.mphipps;

public class Memory_Tester {
	Memory mem;

	public Memory_Tester() {
		mem = new Memory();
	}

	public void run_tests() {
		longword address = new longword();
		longword value = new longword();

		System.out.println("Writing -1 to address 0");
		value.set(-1);
		address.set(0);
		mem.write(address, value);
		if (mem.read(address).getSigned() == -1)
			System.out.println("Value from memory: " + mem.read(address) + " Test Pass");

		System.out.println("Reading memory from address 1, -1 should be shifted right 8 bits");
		address.set(1);
		if (mem.read(address).getSigned() == value.rightShift(8).getSigned()) {
			System.out.println("Address 1 value : " + mem.read(address).toString());
		}

		System.out.println("Reading memory from address 100, 0 should be returned");
		address.set(100);
		if (mem.read(address).getSigned() == 0) {
			System.out.println("Address 100 Value: " + mem.read(address));
		}
	}
}
