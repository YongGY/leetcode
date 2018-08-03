package array.basic;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * @author William
 *
 * 问题描述：判断数组中是否存在<nums[i] nums[j]> abs(nums[i] - nums[j]) <= t  && abs(i - j) <=k；
 *
 * https://zhengyang2015.gitbooks.io/lintcode/contains-duplicate-iii-leetcode-220.html
 */
public class A20_220ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0) {
			return false;
		}
 
		return false;
    }
    
    
    
    public static void main(String[] args) {
    	System.out.println(containsNearbyAlmostDuplicate(new int[] {2,1},1,1));
//		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,2,3,1},3,0));
//		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,0,1,1},1,2));
//		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9},2,3));
	}
}
