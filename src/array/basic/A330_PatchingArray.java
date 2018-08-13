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
 *
 * 我们不妨拿一个具体例子来理顺题目思路，
 * 假定nums = [1, 2, 3, 8, 24]， n = 50。
 *
 * 我们需要逐个查看[1, 50]范围内的数字能否通过组合nums中元素来构成，用cur表示当前检查到的数字。
 *
 * 容易看出cur = 1~6时，[1, 6]范围内的数字能够通过组合nums前三个元素来构成。
 *
 * cur = 7时，不能通过组合nums中前三个元素构成，而下一个待使用的元素8又太大了，不能通过组合nums中元素得出7，
 * 因此需要在nums中添加元素，可选的元素为1~7，如何选择添加的元素是本题的关键，如果我们选择1，则在前三个元素基础上可组合出的范围扩大到[1, 7]，选2的话扩大到[1, 8]，其他同理，如果选7则范围扩大到[1, 13]，可以看出选择的数字越大可以扩展的范围也越大，有利于后续数字的组合，减少在nums中添加元素的可能性，因此这种情况下我们选择在nums中加入7，通过这种贪婪策略即可保证给nums添加的元素最少。在nums中加入7之后，当前能够组合出的数字范围是[1, 13]，cur = 14，此时nums中下一个待使用元素是8，cur > 8，通过加入8能够组合出14，因此不必添加元素，加入8之后又能将组合范围扩大到[1, 21]。此时cur = 22，nums中下一个待使用元素是24，cur < 24，回到了和cur = 7时同样的问题，在nums中加入22，组合范围扩大到[1, 43]。此时cur = 44, nums中下一个待使用元素是24，加入24可以将组合范围扩大到[1, 67]，因此n = 50时只需要在nums中加入7和22即可，返回2。
 *
 * 拿idx表示nums数组中当前使用到的元素位置，如果当前检查的数字cur < nums[idx]，表明需要在nums中添加元素，此时将cur加入nums中可将cur扩大到cur*2的位置；如果当前检查的数字cur >= nums[idx]，此时cur可以通过组合nums中元素来构成，不需要添加元素，在加入nums[idx]之后可以将cur扩大到cur + nums[idx]，同时idx向前进1。持续上述检查直到数字n能够通过nums中数字组合得出即可
 *
 */
public class A330_PatchingArray {
	
	public static int minPatches(int[] nums, int n) {
		long cur = 1;
		int count = 0;
		int i = 0;

		while (cur <= n) {
			if (i < nums.length && nums[i] <= cur) {
				cur = cur + nums[i];
				i++;
			} else {
				cur += cur;
				count++;
			}
		}
		return count;
	}
//	public static int minPatches(int[] nums, int n) {
//		long miss = 1;
//		int count = 0;
//		int i = 0;
//
//		while (miss <= n) {
//			if (i < nums.length && nums[i] <= miss) {
//				miss = miss + nums[i];
//				i++;
//			} else {
//				miss += miss;
//				count++;
//			}
//		}
//		return count;
//	}



//	int minPatches(vector<int>& nums, int n) {
//		int cnt = 0, idx = 0;
//		long long cur = 1;
//		while(cur <= n) {
//			if(idx < nums.size() && cur >= nums[idx]) {
//				cur += nums[idx++];
//			}
//			else {
//				cur += cur;
//				++cnt;
//			}
//		}
//		return cnt;
//	}


	public static void main(String[] args) {
		System.out.println(minPatches(new int[] {1, 4, 10},100));
		System.out.println(minPatches(new int[] {1,5,10},20));
		System.out.println(minPatches(new int[] {1,2,2},5));
	}
}
