package math.basic;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @author William
 */
public class A03_066PlusOne {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i++) {
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
        System.out.println(Arrays.toString(plusOne(new int[]{9, 1})));
    }
}
