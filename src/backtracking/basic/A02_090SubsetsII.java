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
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		List<List<Integer>> res = new ArrayList<>();
//		Arrays.sort(nums);//need to be sorted to track duplicated elements
//		dfs(res, 0, nums, new ArrayList<>());
//		return res;
//	}
//
//	public void dfs(List<List<Integer>> res, int index, int[] nums, List<Integer> path) {
//		res.add(new ArrayList<>(path));
//		for (int i = index; i < nums.length; i++) {
//			if (i > index && nums[i - 1] == nums[i]) {
//				continue;
//			}
//			//Skip duplicates: eg: [1,2,2] will get second [1,2(index=2 bc return from[1,2,2]),i=3)],skip 2nd 2.
//			path.add(nums[i]);
//			dfs(res, i + 1, nums, path);
//			path.remove(path.size() - 1);
//		}
//	}
	
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>(), res);
		return res;
	}

	void dfs(int[] nums, int start, List<Integer> attemp, List<List<Integer>> res) {
		res.add(new ArrayList<>(attemp));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]){
				continue;
			}
			attemp.add(nums[i]);
			dfs(nums, i + 1, attemp, res);
			attemp.remove(attemp.size() - 1);
		}
	}

//	public List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> res = new ArrayList<>();
//		Arrays.sort(nums);
//		dfs(nums, 0, new ArrayList<>(),res);
//		return res;
//	}
//
//	public void dfs(int[] nums, int index,List<Integer> temp,List<List<Integer>> res) {
//		if(index == nums.length){
//			if(!res.contains(temp)){
//				res.add(new ArrayList<>(temp));
//			}
//			return;
//		}
//		temp.add(nums[index]);
//		dfs(nums,index+1,temp,res);
//
//		temp.remove(temp.size()-1);
//		dfs(nums,index+1,temp,res);
//
//	}

	public static void main(String[] args) {
 		
	}
}
