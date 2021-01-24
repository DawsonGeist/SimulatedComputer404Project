package edu.albany.mphipps;

public class longword_test {
	longword a;
	longword b;

	public longword_test() {
		a = new longword();
		b = new longword();
	}

	public void run_tests() {
		// toString Test
		System.out.println("To String test, Should return all zero's");
		if (a.toString().equals("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0")) {
			System.out.println("Test Pass! : " + a.toString());
		} else
			System.out.println("to String test fail!");

		// setBit Test
		System.out.println("Set Bit Test, Should get 1's at beginning and end of the word!");
		bit one = new bit(1);
		a.setBit(0, one);
		a.setBit(31, one);
		if (a.toString().equals("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1")) {
			System.out.println("Test Pass! : " + a.toString());
		} else
			System.out.println("set Bit test fail!");

		// getBit Test
		System.out.println("Get Bit Test: Should return the first bit(1) and the second bit(0)");
		if (a.getBit(0).getValue() == 1 && a.getBit(1).getValue() == 0) {
			System.out.println("Test Pass! 1st Bit Value :" + a.getBit(0) + " second Bit value:" + a.getBit(1));
		} else
			System.out.println("get Bit test fail!");

		// set(value) Test
		System.out.println("Set(Value) Test: We will set the value of the word to Max Int and Negative Max Int");
		a.set(2147483647);
		b.set(-2147483648);
		if ((b.toString().equals("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0"))
				&& (a.toString().equals("0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"))) {
			System.out.println("Set(Value) Test Pass! a: " + a.toString() + " b: " + b.toString());
		} else
			System.out.println("set Value test fail!");

		// and test
		System.out.println("And Test: Should return 1010");
		a.set(10);
		b.set(-1);

		if (a.and(b).toString().equals("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0")) {
			System.out.println("And Test Pass");
			System.out.println("a: " + a.toString());
			System.out.println("b: " + b.toString());
			System.out.println("result: " + a.and(b).toString());
			System.out.println("Does result = a? " + a.equals(a.and(b)));
		} else
			System.out.println("And Test Fail");

		// not test
		a.set(1);
		System.out.println("Not Test: a = " + a.toString());
		if (a.not().toString().equals("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0")) {
			System.out.println("Not Test Pass! Not(a) : " + a.not());
		}

		// get Unsigned Test
		a.set(10);
		System.out.println("Get Unsigned Test: a = " + a.toString());
		if (a.getUnsigned() == 10) {
			System.out.println("a = " + a.getUnsigned());
			a.set(-1);
			long max = 4294967295L;
			if (a.getUnsigned() == max) {
				System.out.println("Get Unsigned Test Pass!");
				System.out.println("a: " + a.toString());
				System.out.println("a= " + a.getUnsigned());
			}
		}

		// get Signed test
		a.set(10);
		System.out.println("Get signed Test: a = " + a.toString());
		if (a.getSigned() == 10) {
			System.out.println("a= " + a.getSigned());
			a.set(-1);
			System.out.println("a: " + a.toString());
			if (a.getSigned() == -1) {
				System.out.println("Get Signed Test Pass!");
				System.out.println("a: " + a.toString());
				System.out.println("a= " + a.getSigned());
			}
		}

		// or test
		a.set(10);
		b.set(1);
		System.out.println("Or Test: a:" + a.toString() + " b:" + b.toString());
		if (a.or(b).getSigned() == 11) {
			System.out.println("Or Test Pass!");
			System.out.println("a|b: " + a.or(b).toString());
		}

		// xor test
		a.set(10);
		b.set(14);
		System.out.println("Xor Test a:" + a.toString() + " b:" + b.toString());
		if (a.xor(b).getSigned() == 4) {
			System.out.println("XOR Test Pass!");
			System.out.println(a.toString());
			System.out.println(b.toString());
			System.out.println(a.xor(b).toString());
		}

		// right SHift test
		a.set(20);
		System.out.println("Right Shift test, 1 and then -1");
		if (a.rightShift(1).getSigned() == 10) {
			a.set(10);
			if (a.rightShift(-1).getSigned() == 20) {
				System.out.println("Right Shift Test Pass!");
			}
		}

		// left shift test
		a.set(20);
		System.out.println("Left Shift test, 1 and then -1");
		if (a.leftShift(1).getSigned() == 40) {
			a.set(10);
			if (a.leftShift(-1).getSigned() == 5) {
				System.out.println("Left Shift Test Pass!");
			}
		}

		// copy test
		a.set(10);
		b.set(0);
		System.out.println("Copy Test a:" + a.toString() + " b:" + b.toString());
		b.copy(a);
		if (b.getSigned() == a.getSigned()) {
			System.out.println("Copy Test Pass!");
			System.out.println(a.toString());
			System.out.println(b.toString());
		}

	}

}
