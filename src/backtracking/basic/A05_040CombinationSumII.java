package backtracking.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * @author William
 *
 */
public class A05_040CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	void dfs(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(index != i && candidates[i - 1] == candidates[i]){
				continue;
			}else if(candidates[i] > target){
				break;
			}
			list.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}

 	public static void main(String[] args) {
 		
	}
}
