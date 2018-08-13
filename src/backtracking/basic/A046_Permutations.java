package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 
 * @author William
 *
 */
public class A046_Permutations {

//	/**
//	 * 【思路-Java、Python】回溯算法|递归实现
//	 *
//	 * 全排列是将一组数按一定顺序进行排列，如果这组数有n个，那么全排列数为n!个。现以{1, 2, 3, 4, 5}为例说明如何编写全排列的递归算法。
//	 *
//	 * 1、首先看最后两个数4, 5。 它们的全排列为4 5和5 4, 即以4开头的5的全排列和以5开头的4的全排列。由于一个数的全排列就是其本身，从而得到以上结果。
//	 *
//	 * 2、再看后三个数3, 4, 5。它们的全排列为3 4 5、3 5 4、 4 3 5、 4 5 3、 5 3 4、 5 4 3 六组数。
//	 * 		即以3开头的和4,5的全排列的组合、以4开头的和3,5的全排列的组合和以5开头的和3,4的全排列的组合。
//	 *
//	 * 从而可以推断，设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，pn = p - {rn}。
//	 * 因此perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。当n = 1时perm(p} = r1。
//	 * 为了更容易理解，将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
//	 */
//	public List<List<Integer>> permute(int[] nums) {
//		List<List<Integer>> res = new ArrayList<>();
//		permute(res, nums, 0);
//		return res;
//	}
//
//	private void permute(List<List<Integer>> res, int[] nums, int pos) {
//		if (pos == nums.length) {
//			List<Integer> list = new ArrayList<>();
//			for (int i = 0; i < nums.length; i++) {
//				list.add(nums[i]);
//			}
//			res.add(list);
//			return;
//		}
//
//		for (int i = pos; i < nums.length; i++) {
//			swap(nums, pos, i);
//			permute(res, nums, pos + 1);
//			swap(nums, pos, i);
//		}
//	}
//
//	private void swap(int[] nums, int i, int j) {
//		int tmp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = tmp;
//	}


	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {  // 如果该元素已经被使用过，则继续遍历
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
