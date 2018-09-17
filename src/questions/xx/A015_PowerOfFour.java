package questions.xx;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 *
 *
 * Function to find whether a given number is a power of 4.
 *
 * @author William
 *
 */
public class A015_PowerOfFour {

	public boolean isPowerOfFour(int num) {
		while (num > 0) {
			if (num == 1) {
				return true;
			}

			if (num % 4 != 0) {
				return false;
			} else {
				num = num / 4;
			}
		}

		return false;
	}

	// Java Solution 2 - Bit Manipulation
	public boolean isPowerOfFour2(int num) {
		int count0 = 0;
		int count1 = 0;

		while (num > 0) {
			if ((num & 1) == 1) {
				count1++;
			} else {
				count0++;
			}

			num >>= 1;
		}

		return count1 == 1 && (count0 % 2 == 0);
	}

}
