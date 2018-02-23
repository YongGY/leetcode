package easy1_199;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus
 * one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author William
 *
 */
public class E066_PlusOne {

	public static int[] plusOne(int[] digits) {
		
		for (int i = digits.length - 1; i >= 0; i--) {
 			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
 
		int[] R = new int[digits.length + 1];
		R[0] = 1;

		return R;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(plusOne(new int[] {9,9,1})));
	}

}
