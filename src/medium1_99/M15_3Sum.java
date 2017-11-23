package medium1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author William
 *
 */


//http://blog.csdn.net/ljiabin/article/details/40620579
//https://segmentfault.com/a/1190000003740669
public class M15_3Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);

		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			
			System.out.println("nums:"+nums+"  (i+1):"+ (i + 1) +"    (len - 1):"+ (len - 1) +"     nums[i]:"+ nums[i]);
			List<List<Integer>> curr = twoSum(nums, i + 1, len - 1, nums[i]); // 寻找两个数与num[i]的和为0
			res.addAll(curr);
		}
		return res;
	}

	public static List<List<Integer>> twoSum(int[] num, int begin, int end, int target) {
		int l = begin, r = end;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		while (l < r) {
			if (num[l] + num[r] + target == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(target);
				ans.add(num[l]);
				ans.add(num[r]);
				res.add(ans); // 放入结果集中
				while (l < r && num[l] == num[l + 1]) l++;
				while (l < r && num[r] == num[r - 1]) r--;
				l++;
				r--;
			} else if (num[l] + num[r] + target < 0) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

}
