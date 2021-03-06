package W.OOD;
import java.util.ArrayList;
import java.util.List;

public class K005_CombinationSum {
	

	/**
	 * 
	 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
	 * 
	 * The same repeated number may be chosen from candidates unlimited number of times.
	 * 
	 * Note:
	 * 
	 * All numbers (including target) will be positive integers.
	 * The solution set must not contain duplicate combinations.
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
	 * 
	 * 
	 * 
	 */
	
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		findCombinationSum(res, nums, 0, target, new ArrayList<Integer>());
		return res;
	}

	public void findCombinationSum(List<List<Integer>> res, int[] nums, int start, int target, List<Integer> path) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			findCombinationSum(res, nums, i, target - nums[i], path);
			path.remove(path.size() - 1);
		}
		return;
	}

}
