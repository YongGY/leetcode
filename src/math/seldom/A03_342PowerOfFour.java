package math.seldom;

/**
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 * 
 * @author William
 *
 */
public class A03_342PowerOfFour {
	
	public boolean isPowerOfFour(int num) {
		while (num > 0 && num % 4 == 0) {
			num /= 4;
		}
		return num == 1;
	}

	public boolean isPowerOfFour1(int num) {
		return num > 0 && (int) (Math.log10(num) / Math.log10(4)) - Math.log10(num) / Math.log10(4) == 0;
	}

	public boolean isPowerOfFour2(int num) {
		if (num <= 0)
			return false;
		return (num & num - 1) == 0 && (num & 0x55555555) == num;
	}

	public boolean isPowerOfFour3(int num) {
		boolean result = false;
		if (num > 0) {
			if (((num & (num - 1)) == 0) && ((num - 1) % 3 == 0)) {
				result = true;
			}
		}
		return result;
	}
    
 	public static void main(String[] args) {
 		
	}
}
