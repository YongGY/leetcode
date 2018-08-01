package backtracking.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * @author William
 *
 */
public class A02_090SubsetsII {

	/**
	 * 思路：Need array to be sorted for skiping duplicated elements.
	 *           用dfs, add path to result every time, skip element when there is duplicate
	 *           remove last char of path once reach end point.
	 * 关键字： Back Tracking
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);//need to be sorted to track duplicated elements
		dfs(res, 0, nums, new ArrayList<>());
		return res;
	}

	public void dfs(List<List<Integer>> res, int index, int[] nums, List<Integer> path) {
		res.add(new ArrayList<>(path));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i - 1] == nums[i]) {
				continue;
			}
			//Skip duplicates: eg: [1,2,2] will get second [1,2(index=2 bc return from[1,2,2]),i=3)],skip 2nd 2.
			path.add(nums[i]);
			dfs(res, i + 1, nums, path);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
 		
	}
}
