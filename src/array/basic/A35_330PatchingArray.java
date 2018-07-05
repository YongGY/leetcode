package array.basic;

/**
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] 
 * inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 * 
 * Example 1:
 * Input: nums = [1,3], n = 6
 * Output: 1 
 * 
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * 
 * Example 2:
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * 
 * Example 3:
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 * 
 * 
 * 这是贪心算法的一个应用。
 * 
 * Analysis
 * Let miss be the smallest number that can not be formed by the sum of elements in the array. 
 * All elements in [0, miss) can be formed. The miss value starts with 1. 
 * If the next number nums[i]<=miss, then the boundary is increased to be [0, miss+nums[i]), because all numbers between the boundaries can be formed; 
 * if next number nums[i]>miss, that means there is a gap and we need to insert a number, 
 * inserting miss itself is a the choice because its boundary doubles and cover every number between the boundaries [0, miss+miss).
 * 
 * Here is an example.
 * Given nums=[1, 4, 10] and n=50.
 * 
 * miss=1;
 * i=0, nums[i]<=miss, then miss=1+1=2
 * i=1, nums[i]>2, then miss = miss+miss = 4
 * i=1, nums[i]<=miss, then miss = miss+num[i] = 8
 * i=2, nums[i]>miss, then miss = miss+miss = 16
 * i=2, nums[i]<miss, then miss = miss+num[i] = 26
 * i=2, nums[i]>miss, then miss = miss+miss = 52 
 * 52 > 50. Done! 4 elements are added!
 * 
 * @author William
 *
 */
public class A35_330PatchingArray {
	
	public static int minPatches(int[] nums, int n) {
		long miss = 1;
		int count = 0;
		int i = 0;

		while (miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss = miss + nums[i];
				i++;
			} else {
				miss += miss;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(minPatches(new int[] {1, 4, 10},100));
		System.out.println(minPatches(new int[] {1,5,10},20));
		System.out.println(minPatches(new int[] {1,2,2},5));
	}
}
