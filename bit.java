package edu.albany.mphipps;

public class bit implements IBit {

	private int value;

	public bit(int value) {
		if (value == 0 || value == 1) {
			this.value = value;
		} else
			System.out.println("Error Invalid Bit Value: Please enter value 0,1");
	}

	public void set(int value) {
		// Set the value to 1 or 0

		if (value == 0 || value == 1) {
			this.value = value;
		} else {
			System.out.println("Error: Invalid value for bit: " + value);
		}

	}

	public void toggle() {
		// changes the value from 0 to 1 or 1 to 0

		if (this.value == 0) {
			this.value = 1;
		} else {
			this.value = 0;
		}

	}

	public void set() {
		// sets the bit to 1

		this.value = 1;

	}

	public void clear() {
		// sets the bit to 0

		this.value = 0;

	}

	public int getValue() {
		// returns the current value

		return this.value;
	}

	public IBit and(IBit other) {
		// performs and on two bits and returns a new bit set to the result

		bit result = new bit(0);

		if ((other.getValue() == this.value) && (this.value == 1)) {
			result.value = 1;
			return result;
		} else {
			return result;
		}

	}

	public IBit or(IBit other) {
		// performs or on two bits and returns a new bit set to the result

		bit result = new bit(0);

		if (other.getValue() == 1 || this.value == 1) {
			result.value = 1;
			return result;
		} else {
			return result;
		}
	}

	public IBit xor(IBit other) {
		// performs xor on two bits and returns a new bit set to the result

		bit result = new bit(0);

		if (other.getValue() != this.value) {
			result.value = 1;
			return result;
		} else {
			return result;
		}
	}

	public IBit not() {
		// performs not on the existing bit, returning the result as a new bit
		bit result = new bit(0);
		if (this.value == 0) {
			result.value = 1;
		} else {
			result.value = 0;
		}
		return result;
	}

	@Override
	public String toString() {
		return "" + this.value;
	}

}
