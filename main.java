package edu.albany.mphipps;

public class main {

	public static void main(String[] args) {
		// bit_test bitTester = new bit_test();
		// bitTester.runTests();

		// longword_test longwordTester = new longword_test();
		// longwordTester.run_tests();

		// rippleAdder_test adderTester = new rippleAdder_test();
		// adderTester.run_tests();

		// multiplier_test multTest = new multiplier_test();
		// multTest.run_tests();

		// ALU_Test aluTest = new ALU_Test();
		// aluTest.run_tests();

		// Memory_Tester memTest = new Memory_Tester();
		// memTest.run_tests();

		Assembler assembler = new Assembler();
		String[] instructionsB = { "Move R1 1", "Push R1", "Move R1 10", "Pop R5", "Halt" };

		for (int i = 0; i < 5; i++) {
			System.out.println(assembler.assemble(instructionsB)[i]);
		}

		// cpu_test1 cpuTest = new cpu_test1();
		// cpuTest.run_tests();

		// Computer comp = new Computer();
		// comp.preload(instructions);
		// comp.run();

		// cpu_test2.test();

		cpu_test3.test();

	}

}
