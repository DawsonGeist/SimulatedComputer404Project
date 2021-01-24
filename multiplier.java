package edu.albany.mphipps;

public class multiplier {

	public static longword multiply(longword a, longword b) {
		/*
		 * a*b
		 * 
		 * 0110 a * 1001 b ____ 0110 0000 0000 0110 +_______ 00110110
		 */
		rippleAdder adder = new rippleAdder();
		longword result = new longword();
		longword temp = new longword();

		for (int i = 0; i < 32; i++) {
			// Check if B is 1 :: if so, a = a << i; result = result + a, --> reset a: a = a
			// >> i
			if (b.getBit(i).getValue() == 1) {
				temp = a.leftShift(i);
				result.set(adder.add(result, temp).getSigned());
			}
		}

		return result;
	}

}
