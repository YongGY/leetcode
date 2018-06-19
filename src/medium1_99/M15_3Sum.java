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
 *         1.先对数组排序 2.对数组用两个指针分别从前后两端向中间扫描
 *         3.先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了(3数相加为0) 注意，对于 num[i]，寻找另外两个数时，只要从
 *         i+1 开始找就可以了。
 *         这种写法，可以避免结果集中有重复，因为数组时排好序的，所以当一个数被放到结果集中的时候，其后面和它相等的直接被跳过。
 */

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

			System.out.println("nums:" + Arrays.toString(nums) + "  (begin):" + (i + 1) + "    (end):" + (len - 1)
					+ "     (target):" + nums[i]);
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
				while (l < r && num[l] == num[l + 1])
					l++;
				while (l < r && num[r] == num[r - 1])
					r--;
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

	public static List<List<Integer>> threeSum2(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums == null || nums.length<3)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-2; i++){
	        if(i==0 || nums[i] > nums[i-1]){
	            int j=i+1;
	            int k=nums.length-1;
	 
	            while(j<k){
	                if(nums[i]+nums[j]+nums[k]==0){
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[k]);
	                    result.add(l);
	 
	                    j++;
	                    k--;
	 
	                    //handle duplicate here
	                    while(j<k && nums[j]==nums[j-1])
	                        j++;
	                    while(j<k && nums[k]==nums[k+1])
	                        k--;
	 
	                }else if(nums[i]+nums[j]+nums[k]<0){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }
	 
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum2(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

}
