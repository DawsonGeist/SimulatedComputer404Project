package edu.albany.mphipps;

public class bit_test {

	public bit a;
	public bit b;

	public bit_test() {
		this.a = new bit(0);
		this.b = new bit(0);
	}

	public void runTests() {

		// getValue Test
		if ((a.getValue() == 1 || a.getValue() == 0) && (b.getValue() == 1 || b.getValue() == 0)) {
			System.out.println("getValue Test: Pass");
		} else {
			System.out.println("getValue Test: Fail or Invalid value for bit a or b");
		}

		// Set(Value) Test
		a.set(1);
		b.set(0);
		if (a.getValue() != b.getValue() && a.getValue() == 1) {
			System.out.println("Set(Value) Test: Pass");
		} else {
			System.out.println("Set(Value) Test: Fail");
		}

		// Toggle Test
		a.toggle();
		b.toggle();
		if (a.getValue() != b.getValue() && a.getValue() == 0) {
			System.out.println("Toggle Test: Pass");
		} else {
			System.out.println("Toggle Test: Fail");
		}

		// Set Test
		a.set();
		b.set();
		if (a.getValue() == b.getValue() && a.getValue() == 1) {
			System.out.println("Set() Test: Pass");
		} else {
			System.out.println("Set() Test: Fail");
		}

		// Clear Test
		a.clear();
		b.clear();
		if (a.getValue() == b.getValue() && a.getValue() == 0) {
			System.out.println("Clear() Test: Pass");
		} else {
			System.out.println("Clear() Test: Fail");
		}

		// And(0&0) Test
		if (a.and(b).getValue() == 1) {
			System.out.println("a: 0;b: 0; A & B = 1; Pass");
		} else {
			System.out.println("And test(0&0): Fail");
		}

		// And(1&1)
		a.toggle();
		b.toggle();
		if (a.and(b).getValue() == 1) {
			System.out.println("a: 1;b: 1; A & B = 1; Pass");
		} else {
			System.out.println("And test(1&1): Fail");
		}

		// And(0&1)
		a.toggle();
		if (a.and(b).getValue() == 0) {
			System.out.println("a: 0;b: 1; A & B = 0; Pass");
		} else {
			System.out.println("And test(0&1): Fail");
		}

		// And(1&0)
		a.toggle();
		b.toggle();
		if (a.and(b).getValue() == 0) {
			System.out.println("a: 1;b: 0; A & B = 0; Pass");
		} else {
			System.out.println("And test(1&0): Fail");
		}

		// And(0&0)
		a.clear();
		b.clear();
		if (a.and(b).getValue() == 0) {
			System.out.println("a: 0;b: 0; A & B = 0; Pass");
		} else {
			System.out.println("And test(0&0): Fail");
		}

		// Or(0|0)
		a.clear();
		b.clear();
		if (a.or(b).getValue() == 0) {
			System.out.println("a: 0;b: 0; A or B = 0; Pass");
		} else {
			System.out.println("Or test(0 or 0): Fail");
		}

		// or(0|1)
		b.set();
		if (a.or(b).getValue() == 1) {
			System.out.println("a: 0;b: 1; A or B = 1; Pass");
		} else {
			System.out.println("Or test(0 or 1): Fail");
		}

		// or(1|0)
		b.clear();
		a.set();
		if (a.or(b).getValue() == 1) {
			System.out.println("a: 1;b: 0; A or B = 1; Pass");
		} else {
			System.out.println("Or test(1 or 0): Fail");
		}

		// or(1|1)
		b.set();
		if (a.or(b).getValue() == 1) {
			System.out.println("a: 1;b: 1; A or B = 1; Pass");
		} else {
			System.out.println("Or test(1 or 1): Fail");
		}

		// Xor(0xor0) Test
		a.clear();
		b.clear();
		if (a.xor(b).getValue() == 0) {
			System.out.println("a: 0;b: 0; A xor B = 0; Pass");
		} else {
			System.out.println("XOR(00) Test: Fail");
		}

		// Xor(1xor1) Test
		a.set();
		b.set();
		if (a.xor(b).getValue() == 0) {
			System.out.println("a: 1;b: 1; A xor B = 0; Pass");
		} else {
			System.out.println("XOR(11) Test: Fail");
		}

		// Xor(0xor1) Test
		a.clear();
		b.set();
		if (a.xor(b).getValue() == 1) {
			System.out.println("a: 0;b: 1; A xor B = 1; Pass");
		} else {
			System.out.println("XOR(01) Test: Fail");
		}

		// Xor(1Xor0) Test
		a.set();
		b.clear();
		if (a.xor(b).getValue() == 1) {
			System.out.println("a: 1;b: 0; A xor B = 1; Pass");
		} else {
			System.out.println("XOR(10) Test: Fail");
		}

		// Not test
		if (a.getValue() != a.not().getValue()) {
			System.out.println("a: " + a.getValue() + ";a NOT: " + a.not().getValue() + "; Pass");
		} else {
			System.out.println("Not Test: Fail");
		}

		// toString test
		if ((a.toString().equals("1") || a.toString().equals("0"))
				&& (b.toString().equals("1") || b.toString().equals("0"))) {
			System.out.println("toString test: Pass with acceptable bit values");
		} else {
			System.out.println("toString test: Fail or Unacceptable bit values");
		}
	}

}
