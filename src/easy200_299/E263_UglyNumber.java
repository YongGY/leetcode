package easy200_299;

/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 */

public class E263_UglyNumber {

	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		if (num == 1)
			return true;
		
		while (num >= 2 && num % 2 == 0)
			num /= 2;
		while (num >= 3 && num % 3 == 0)
			num /= 3;
		while (num >= 4 && num % 4 == 0)
			num /= 4;

		return num == 1;
	}

//	简洁版
//	for (int i=2; i<6 && num>0; i++)
//	    while (num % i == 0)
//	        num /= i;
//	return num == 1;
	
}
