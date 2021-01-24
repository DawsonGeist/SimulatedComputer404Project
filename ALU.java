package edu.albany.mphipps;

public class ALU {

	public static longword doOp(bit[] opCode, longword a, longword b) {

		int index = 0;
		String op = "";
		while (index < opCode.length) {
			op += opCode[index].getValue();
			index++;
		}

		longword returner = new longword();

		switch (op) {
		case "1000":
			// and
			returner = a.and(b);
			break;

		case "1001":
			// or
			returner = a.or(b);
			break;

		case "1010":
			// xor
			returner = a.xor(b);
			break;

		case "1011":
			// not
			returner = a.not();
			break;

		case "1100":
			// LS
			returner = a.leftShift(b.getSigned());
			break;

		case "1101":
			// RS
			returner = a.rightShift(b.getSigned());
			break;

		case "1110":
			// add
			returner = rippleAdder.add(a, b);
			break;

		case "1111":
			// subtract
			returner = rippleAdder.subtract(a, b);
			break;

		case "0111":
			// multiply
			returner = multiplier.multiply(a, b);
			break;
		}

		return returner;
	}

}
