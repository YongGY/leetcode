package difficulty.easy1_199;

import java.util.ArrayList;

import a0_common.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
 * 
 * @author William
 *
 */
public class E107_BinaryTreeLevelOrderTraversal_II {

    //A good implementation problem
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		levelOrder(root, results, 0);
		return results;
	}

	private void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> results, int level) {
		if (root == null) {
			return;
		}

		ArrayList<Integer> current = new ArrayList<Integer>();
		if (results.size() <= level) {
			current.add(root.val);
			results.add(0, current);
		} else {
			current = results.get(results.size() - level - 1);
			current.add(root.val);
		}

		levelOrder(root.left, results, level + 1);
		levelOrder(root.right, results, level + 1);
	}

}
