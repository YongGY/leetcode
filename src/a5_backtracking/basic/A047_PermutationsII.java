package a5_backtracking.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 
 * @author William
 *
 */
public class A047_PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);  //排序有利于判断重复值
		dfs(nums, used, new ArrayList<>(), res);//深度优先算法
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {  //如果结果长度和输入长度相等，则添加进结果集
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {  // 如果该元素已经被使用过，则继续遍历
				continue;
			}
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {   //下一个重复值只有在前一个重复值被使用的情况下才可以使用
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
    
 	public static void main(String[] args) {
 		
	}
}
