package edu.albany.mphipps;

public class rippleAdder_test {
	private longword a;
	private longword b;
	private rippleAdder adder;

	public rippleAdder_test() {
		a = new longword();
		b = new longword();
		a.set(0);
		b.set(0);
		rippleAdder adder = new rippleAdder();
	}

	public void run_tests() {
		// Both positive values, a+b then b+a
		a.set(50);
		b.set(100);
		System.out.println("Testing add method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.add(a, b).getSigned() == 150) {
			System.out.println("Add 2 positives success: Result = " + adder.add(a, b).getSigned());
		}
		System.out.println("Testing add method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.add(b, a).getSigned() == 150) {
			System.out.println("Add 2 positives success: Result = " + adder.add(b, a).getSigned() + "\n");
		}

		// One negative one positive, a+b then b+a
		a.set(-50);
		System.out.println("Testing add method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.add(a, b).getSigned() == 50) {
			System.out.println("Add 1 negative 1 positive success: Result = " + adder.add(a, b).getSigned());
		}
		System.out.println("Testing add method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.add(b, a).getSigned() == 50) {
			System.out.println("Add 1 negative 1 positive success: Result = " + adder.add(b, a).getSigned() + "\n");
		}

		// Both negative, a+b then b+a
		b.set(-100);
		System.out.println("Testing add method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.add(a, b).getSigned() == -150) {
			System.out.println("Add both negative Success: Result = " + adder.add(a, b).getSigned());
		}
		System.out.println("Testing add method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.add(b, a).getSigned() == -150) {
			System.out.println("Add both negative Success: Result = " + adder.add(b, a).getSigned() + "\n");
		}

		// Both positive values, a-b then b-a
		a.set(50);
		b.set(100);
		System.out.println("Testing subtract method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.subtract(a, b).getSigned() == -50) {
			System.out.println("Subtract 2 positives success: Result = " + adder.subtract(a, b).getSigned());
		}
		System.out.println("Testing subtract method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.subtract(b, a).getSigned() == 50) {
			System.out.println("Subtract 2 positives success: Result = " + adder.subtract(b, a).getSigned() + "\n");
		}

		// One negative one positive, a-b then b-a
		a.set(-50);
		System.out.println("Testing subtract method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.subtract(a, b).getSigned() == -150) {
			System.out.println("subtract 1 negative 1 positive success: Result = " + adder.subtract(a, b).getSigned());
		}
		System.out.println("Testing subtract method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.subtract(b, a).getSigned() == 150) {
			System.out.println(
					"Subtract 1 negative 1 positive success: Result = " + adder.subtract(b, a).getSigned() + "\n");
		}

		// Both negative, a-b then b-a
		b.set(-100);
		System.out.println("Testing subtract method with values " + a.getSigned() + ", " + b.getSigned());
		if (adder.subtract(a, b).getSigned() == 50) {
			System.out.println("Subtract both negative Success: Result = " + adder.subtract(a, b).getSigned());
		}
		System.out.println("Testing subtract method with values " + b.getSigned() + ", " + a.getSigned());
		if (adder.subtract(b, a).getSigned() == -50) {
			System.out.println("Subtract both negative Success: Result = " + adder.subtract(b, a).getSigned());
		}

	}
}
