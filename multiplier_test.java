package edu.albany.mphipps;

public class multiplier_test {
	longword a;
	longword b;

	public multiplier_test() {
		a = new longword();
		b = new longword();
	}

	public void run_tests() {
		a.set(10);
		b.set(5);
		System.out.println("Positive Values Test: a= " + a.getSigned() + " b= " + b.getSigned());
		if (multiplier.multiply(a, b).getSigned() == 50) {
			System.out.println("Test Pass: a*b=" + multiplier.multiply(a, b).getSigned());
		}

		a.set(10);
		b.set(-5);
		System.out.println("Mixed Values Test: a= " + a.getSigned() + " b= " + b.getSigned());
		if (multiplier.multiply(a, b).getSigned() == -50) {
			System.out.println("Test Pass: a*b=" + multiplier.multiply(a, b).getSigned());
		}

		a.set(-10);
		b.set(-5);
		System.out.println("Negative Values Test: a= " + a.getSigned() + " b= " + b.getSigned());
		if (multiplier.multiply(a, b).getSigned() == 50) {
			System.out.println("Test Pass: a*b=" + multiplier.multiply(a, b).getSigned());
		}

		a.set(-10);
		b.set(0);
		System.out.println("Zero Value Test: a= " + a.getSigned() + " b= " + b.getSigned());
		if (multiplier.multiply(a, b).getSigned() == 0) {
			System.out.println("Test Pass: a*b=" + multiplier.multiply(a, b).getSigned());
		}
	}
}
