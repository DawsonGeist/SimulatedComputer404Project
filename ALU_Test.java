package edu.albany.mphipps;

public class ALU_Test {

	bit[] op;
	longword a;
	longword b;

	public ALU_Test() {
		op = new bit[4];
		for (int i = 0; i < 4; i++) {
			op[i] = new bit(0);
		}
		a = new longword();
		b = new longword();
	}

	public void run_tests() {
		// 1000
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].clear();
		op[2].clear();
		op[3].clear();
		System.out.println("ALU AND a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.and(b).getSigned()) {
			System.out.println("Test Pass");
		}
		// 1001
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].clear();
		op[2].clear();
		op[3].set();
		System.out.println("ALU OR a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.or(b).getSigned()) {
			System.out.println("Test Pass");
		}

		// 1010
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].clear();
		op[2].set();
		op[3].clear();
		System.out.println("ALU XOR a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.xor(b).getSigned()) {
			System.out.println("Test Pass");
		}

		// 1011
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].clear();
		op[2].set();
		op[3].set();
		System.out.println("ALU NOT a: " + a.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.not().getSigned()) {
			System.out.println("Test Pass");
		}

		// 1100
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].set();
		op[2].clear();
		op[3].clear();
		System.out.println("ALU LS a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.leftShift(b.getSigned()).getSigned()) {
			System.out.println("Test Pass");
		}

		// 1101
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].set();
		op[2].clear();
		op[3].set();
		System.out.println("ALU RS a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == a.rightShift(b.getSigned()).getSigned()) {
			System.out.println("Test Pass");
		}

		// 1110
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].set();
		op[2].set();
		op[3].clear();
		System.out.println("ALU ADD a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == rippleAdder.add(a, b).getSigned()) {
			System.out.println("Test Pass");
		}

		// 1111
		a.set(-1);
		b.set(10);
		op[0].set();
		op[1].set();
		op[2].set();
		op[3].set();
		System.out.println("ALU SUBTRACT a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == rippleAdder.subtract(a, b).getSigned()) {
			System.out.println("Test Pass");
		}

		// 0111
		a.set(-1);
		b.set(10);
		op[0].clear();
		op[1].set();
		op[2].set();
		op[3].set();
		System.out.println("ALU MULTIPLY a: " + a.getSigned() + " b:" + b.getSigned());
		if (ALU.doOp(op, a, b).getSigned() == multiplier.multiply(a, b).getSigned()) {
			System.out.println("Test Pass");
		}
	}
}
