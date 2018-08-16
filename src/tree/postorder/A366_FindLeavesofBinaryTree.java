package tree.postorder;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * 		Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Returns [4, 5, 3], [2], [1].
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *           1
 *          /
 *         2
 * 2. Now removing the leaf [2] would result in this tree:
 *           1
 * 3. Now removing the leaf [1] would result in the empty tree:
 *           []
 * Returns [4, 5, 3], [2], [1].
 * 
 * @author William
 *
 *  注意点：当前node的高度是 1 + Max（height(node.left),height(node.right)）。
 *  	   leaf的高度是0
 *         The height of a node is also the its index in the result list (res).
 *
 *	复杂度  O(N) 时间 O(N) 空间
 *
 * 	思路
 * 	这道题换句话说就是找每个node的index，这个index就是最后结果中这个节点所在的list的index，
 * 	比如4,5,3的index是0，2的index是1，1的index是2.
 * 	怎么找呢？二分，看左，看右。
 * 	确定一个点的index，得知道他的左孩子index是多少，右孩子的index是多少，当前这个点的index是他左右孩子的index最大值+1，这可以很容易地观察得到。
 * 	比如对于1来说，左孩子2的index是1，右孩子3的index是0，那1的index肯定是max(1, 0) + 1，即2.
 *
 */
public class A366_FindLeavesofBinaryTree {

	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,res);
		return res;
	}

	//calculate the index of this root passed in and put it in that index, at last return where this root was put
	private static int dfs(TreeNode node,List<List<Integer>> res) {
		if (node == null) {
			return -1;
		}
		int left = dfs(node.left,res);
		int right = dfs(node.right,res);
		int cur = Math.max(left, right) + 1;
		// the first time this code is reached is when curr==0, since the tree is bottom-up processed.
		if (res.size() == cur) {
			res.add(new ArrayList<>());
		}
		res.get(cur).add(node.val);
		return cur;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right = t5;

		System.out.println(findLeaves(t1));
	}
}
