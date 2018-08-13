package math.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * https://kingsfish.github.io/2017/07/13/Leetcode-18-4Sum/
 *
 * @author William
 *
 */
public class A018_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i<len -3; i++){
			for(int j = i + 1; j<len -2; j++){
				int left = j + 1;
				int right = len - 1;
				while(left < right){
					int sum = nums[left] + nums[right] + nums[i] + nums[j];
					if(sum == target){
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						res.add(list);
						left++;
						right--;
						while(left < right && nums[left] == nums[left-1]) left++;
						while(left < right && nums[right] == nums[right+1]) right--;
					}else if(sum < target){
						left++;
					}else{
						right--;
					}
				}
				while(j < len -2 && nums[j] == nums[j+1]) j++;
			}
			while(i < len -3 && nums[i] == nums[i+1]) i++;
		}
		return res;
	}
    
 	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
	}
}
