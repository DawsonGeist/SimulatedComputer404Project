package edu.albany.mphipps;

public class cpu_test1 {

	Computer comp;
	String instructions[];

	public cpu_test1() {
		comp = new Computer();
		instructions = new String[6];
	}

	public void run_tests() {
		String halt = "0000 0000 0000 0000";
		String moveR210 = "0001 0010 0000 1010";
		String moveR1Negative1 = "0001 0001 1111 1111";
		String interrupt0 = "0010 0000 0000 0000";
		String interrupt1 = "0010 0000 0000 0001";
		String addR1R2R3 = "1110 0001 0010 0011";

		instructions[0] = moveR210;
		instructions[1] = moveR1Negative1;
		instructions[2] = addR1R2R3;
		instructions[3] = interrupt0;
		instructions[4] = interrupt1;
		instructions[5] = halt;

		comp.preload(instructions);
		comp.run();

	}

}
