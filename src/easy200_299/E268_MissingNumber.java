package easy200_299;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1
 * 
 * Input: [3,0,1] Output: 2 Example 2
 * 
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8
 * 
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 */

public class E268_MissingNumber {

	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] + 1 != nums[i+1]) {
				return nums[i] + 1;
			}
		}
		return 0;
	}

	
	public static void main(String[] args) {
		System.out.println(missingNumber(new int [] {3,0,1}));
		System.out.println(missingNumber(new int [] {9,6,4,3,5,7}));
	}
}
