package edu.albany.mphipps;

public class rippleAdder {

	public static longword add(longword a, longword b) {
		int carry = 0;
		longword result = new longword();

		for (int i = 0; i < 32; i++) {
			// if carry = 1 AND both longwords a, b have '1' value bit: set result bit to 1,
			// carry = 1
			if ((carry == 1) && a.getBit(i).and(b.getBit(i)).getValue() == 1) {
				result.getBit(i).set(1);
				carry = 1;
			}
			// if carry = 0 AND both longwords a, b have '1' value bit: set result bit to 0,
			// carry = 1
			else if ((carry == 0) && a.getBit(i).and(b.getBit(i)).getValue() == 1) {
				result.getBit(i).set(0);
				carry = 1;
			}
			// if carry = 1 AND either longwords a, b have '1' value bit: set result bit to
			// 0, carry = 1
			else if ((carry == 1) && a.getBit(i).or(b.getBit(i)).getValue() == 1) {
				result.getBit(i).set(0);
				carry = 1;
			}
			// if carry = 0 AND either longwords a, b have '1' value bit: set result bit to
			// 1, carry = 0
			else if ((carry == 0) && a.getBit(i).or(b.getBit(i)).getValue() == 1) {
				result.getBit(i).set(1);
				carry = 0;
			}
			// if carry = 1 AND both longwords a, b have '0' value bit: set result bit to 1,
			// carry = 0
			else if ((carry == 1) && a.getBit(i).or(b.getBit(i)).getValue() == 0) {
				result.getBit(i).set(1);
				carry = 0;
			}
			// if carry = 0 AND both longwords a, b have '0' value bit: set result bit to 0,
			// carry = 0
			else if ((carry == 1) && a.getBit(31 - i).or(b.getBit(31 - i)).getValue() == 0) {
				result.getBit(31 - i).set(0);
				carry = 0;
			}

		}
		return result;
	}

	public static longword subtract(longword a, longword b) {
		// negate b then pass a, -b to add
		longword notB = new longword();
		notB.set(b.getSigned());

		for (int i = 0; i < 32; i++) {
			notB.getBit(i).set(notB.getBit(i).not().getValue());
		}

		// add 1 (2's compliment)
		if (notB.getBit(0).getValue() == 0) {
			notB.getBit(0).set();
		} else {
			int index = 0;
			while (notB.getBit(index).getValue() == 1) {
				notB.getBit(index).clear();
				index++;
			}
			notB.getBit(index).set();
		}

		longword result = add(a, notB);
		return result;
	}

}
