package a4_tree.level;

import java.util.ArrayList;
import java.util.List;

import a0_common.TreeNode;

/**
 * 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author William
 *
 * Time Complexity - O(2^n)， Space Complexity - O(2^n)
 */
public class A095_UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		return helper(1, n);
	}

	public List<TreeNode> helper(int left, int right) {
		List<TreeNode> result = new ArrayList<>();
		if (left > right) {
			result.add(null);
			return result;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftSubTree = helper(left, i - 1);
			List<TreeNode> rightSubTree = helper(i + 1, right);
			for (TreeNode l : leftSubTree) {
				for (TreeNode r : rightSubTree) {
					TreeNode curr = new TreeNode(i);
					curr.left = l;
					curr.right = r;
					result.add(curr);
				}
			}
		}
		return result;
	}

 	public static void main(String[] args) {
 		
	}
}
