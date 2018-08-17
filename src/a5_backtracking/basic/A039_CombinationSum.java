package a5_backtracking.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 
 * @author William
 *
 */
public class A039_CombinationSum {

	/**
	 * ## Idea
	 * * Backtracking
	 * * pass res, temp list , nums , remaining value and position to a helper function
	 * * Must avoid dulicpate compuatation
	 * * For example set [2, 3, 6, 7] and target 7
	 * * Must avoid 7 - 2 -2 -2 -2 - 2 - 2 solution
	 * * So, we mush set remain >= 0
	 * * When remain = 0, add temp list  to res
	 * * For backtracking, we add nums[i] to list, backtracking to current position( Only calculate nums after and in the position)
	 * * Then track back : remove current nums[i]
	 *
	 * ## Time
	 * * cn0 + cn1 + cn2 + cn3 + ... + cnn = 2^n
	 */

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private static void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
		if (target == 0) { // 如果当前和等于目标，说明这是一条正确路径，记录该路径
			res.add(new ArrayList<>(list));
			return;
		}
		// 否则，对剩余所有可能性进行深度优先搜索,   选取之后的每个数字都是一种可能性
		for (int i = start; i < candidates.length; i++) {
			if(candidates[i] > target){
				break;
			}
			// 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法
			list.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, list, res);
			list.remove(list.size() - 1);
		}
	}


	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		System.out.println(combinationSum(nums, 7));
	}
}
