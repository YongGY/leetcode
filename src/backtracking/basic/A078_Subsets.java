package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * @author William
 *
 */
public class A078_Subsets {

	/**
	 * 【思路1-Java】回溯算法|递归实现
	 *
	 * 本解法采用回溯算法实现，回溯算法的基本形式是“递归+循环”，正因为循环中嵌套着递归，递归中包含循环，这才使得回溯比一般的递归和单纯的循环更难理解，
	 * 其实我们熟悉了它的基本形式，就会觉得这样的算法难度也不是很大。
	 * 原数组中的每个元素有两种状态：存在和不存在。
	 *
	 * ① 外层循环逐一往中间集合 temp 中加入元素 nums[i]，使这个元素处于存在状态
	 *
	 * ② 开始递归，递归中携带加入新元素的 temp，并且下一次循环的起始是 i 元素的下一个，因而递归中更新 i 值为 i + 1
	 *
	 * ③ 将这个从中间集合 temp 中移除，使该元素处于不存在状态
	 *
	 * [1,2,3]	  1       2		  3
	 * 		[]   [1]    [12] 	[123]
	 * 			 []				[12]
	 * 			 		[1\]	[13]
	 * 			 				[1]
	 * 			 []		[2]		[23]
	 * 			 		[\]		[2]
	 * 			 				[3]
	 * 			 				[\]
	 *
	 *  (2^N)
	 */
//	public List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> res = new ArrayList<>();
//		dfs(nums, 0, new ArrayList<>(),res);
//		return res;
//	}
//
//	public void dfs(int[] nums, int index,List<Integer> temp,List<List<Integer>> res) {
//		if(index == nums.length){
//			res.add(new ArrayList<>(temp));
//			return;
//		}
//		temp.add(nums[index]);
//		dfs(nums,index+1,temp,res);
//
//		temp.remove(temp.size()-1);
//		dfs(nums,index+1,temp,res);
//
//	}
//	
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null) {
			return res;
		}
		dfs(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}


	/**
	 * 这种方法是一种组合的方式
	 *
	 * ① 最外层循环逐一从 nums 数组中取出每个元素 num
	 *
	 * ② 内层循环从原来的结果集中取出每个中间结果集，并向每个中间结果集中添加该 num 元素
	 *
	 * ③往每个中间结果集中加入 num
	 *
	 * ④将新的中间结果集加入结果集中
	 */
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int num : nums) {  // ①从数组中取出每个元素
			int size = res.size();
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
				temp.add(num);  // ③将 num 放入中间结果集
				res.add(temp);  // ④加入到结果集中
			}
		}
		return res;
	}


	public static void main(String[] args) {
 		
	}
}
