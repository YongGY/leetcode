package math.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 
 * @author William
 *
 */
public class A03_015_3Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 3){
			return res;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			if(i == 0 || nums[i] > nums[i -1]){
				int left = i + 1;
				int right = len - 1;
				while (left < right) {
					int sum = nums[left] + nums[right] + nums[i];
					if (sum == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[left]);
						list.add(nums[right]);
						res.add(list);

						left++;
						right--;
						//handle duplicate here
						while(left < right && nums[left] == nums[left - 1]){
							left++;
						}
						while(left < right && nums[right] == nums[right + 1]){
							right--;
						}

					}else if(sum < 0){
						left++;
					}else{
						right--;
					}
				}
			}
		}
		return res;
	}

 	public static void main(String[] args) {
 		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
