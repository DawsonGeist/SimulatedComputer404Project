package edu.albany.mphipps;

public abstract class cpu_test3 {
	static Computer comp = new Computer();
	static Assembler a = new Assembler();

	public static void test() {
		// Push
		System.out.println("Test Push");
		String[] instructions = { "Move R1 1", "Push R1", "Move R1 10", "Push R1", "Interrupt 1", "Halt" };
		comp.preload(a.assemble(instructions));
		comp.run();

		// Pop
		System.out.println("\nTest Pop");
		String[] instructionsB = { "Move R1 1", "Push R1", "Move R1 10", "Pop R5", "Interrupt 0", "Halt" };
		comp = new Computer();
		comp.preload(a.assemble(instructionsB));
		comp.run();

		// Call
		System.out.println("\nTest Call");
		String[] instructionsC = { "Move R1 1", "call 6", "Halt", "Push R1", "Pop R5", "Interrupt 0", "Halt" };
		comp = new Computer();
		comp.preload(a.assemble(instructionsC));
		comp.run();

		// Return
		System.out.println("\nTest Return");
		String[] instructionsD = { "Move R1 16", "call 12", "Interrupt 0", "Halt", "Push R1", "Pop R5", "Return",
				"Interrupt 1", "Halt" };
		comp = new Computer();
		comp.preload(a.assemble(instructionsD));
		comp.run();
	}

}
