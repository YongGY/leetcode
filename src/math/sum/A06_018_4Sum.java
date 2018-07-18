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
public class A06_018_4Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i<len -3; i++){
			for(int j = i + 1; j<len -2; j++){
				List<Integer> list = new ArrayList<>();
				int left = j + 1;
				int right = len - 1;
				int temp =  nums[i] + nums[j];
				while(left < right){
					int sum = nums[left] + nums[right] + temp;
					if(sum == target){

					}
				}


			}



		}

	}
    
 	public static void main(String[] args) {
		System.out.println("aaa");
	}
}
