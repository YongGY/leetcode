package a2_string.basic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @author William
 *
 */
public class A18_179LargestNumber {

	public static String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			str[i] = String.valueOf(nums[i]);

		Comparator<String> comp = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		};
		Arrays.sort(str, comp);
		if (str[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for (String s : str)
			sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
	}
}
