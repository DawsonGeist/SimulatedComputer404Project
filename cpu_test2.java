package edu.albany.mphipps;

public abstract class cpu_test2 {
	static Computer comp = new Computer();
	static Assembler a = new Assembler();

	public static void test() {
		// Branch if Not equal
		String[] instructions = { "Move R1 0", // 0
				"Move R2 1", // 2
				"Move R3 5", // 4
				"Jump 12", // 6
				"Interrupt 0", // 8
				"Halt", // 10
				"Compare R1 R3", // 12
				"BranchIfNotEqual 4", // 14
				"Jump 8", // 16
				"Add R1 R2 R1", // 18
				"Jump 12", // 20
		};
		String[] code = a.assemble(instructions);
		comp.preload(code);
		comp.run();

		System.out.println("^^^^If R1 = R3 = 5 : Test Pass");

		// Branch if Equal
		String[] instructionsB = { "Move R1 0", // 0
				"Move R2 1", // 2
				"Move R3 5", // 4
				"Jump 12", // 6
				"Interrupt 0", // 8
				"Halt", // 10
				"Compare R1 R3", // 12
				"BranchIfEqual -6", // 14
				"Add R1 R2 R1", // 16
				"Jump 12", // 18
		};
		code = a.assemble(instructionsB);
		comp = new Computer();
		comp.preload(code);
		comp.run();

		System.out.println("^^^^If R1 = R3 = 5 : Test Pass");

		// Branch if Greater Than
		String[] instructionsC = { "Move R1 0", // 0
				"Move R2 1", // 2
				"Move R3 5", // 4
				"Jump 12", // 6
				"Interrupt 0", // 8
				"Halt", // 10
				"Compare R1 R3", // 12
				"BranchIfGreaterThan -6", // 14
				"Add R1 R2 R1", // 16
				"Jump 12", // 18
		};
		code = a.assemble(instructionsC);
		comp = new Computer();
		comp.preload(code);
		comp.run();

		System.out.println("^^^^If R1 > R3 (6>5) : Test Pass");

		// Branch if Greater than or Equal
		String[] instructionsD = { "Move R1 0", // 0
				"Move R2 1", // 2
				"Move R3 5", // 4
				"Jump 12", // 6
				"Interrupt 0", // 8
				"Halt", // 10
				"Compare R3 R1", // 12
				"BranchIfGreaterThanOrEqual -6", // 14
				"Add R1 R2 R1", // 16
				"Jump 12", // 18
		};
		code = a.assemble(instructionsD);
		comp = new Computer();
		comp.preload(code);
		comp.run();

		System.out.println("^^^^If R1 = R3 = 5 : Test Pass");

	}
}
