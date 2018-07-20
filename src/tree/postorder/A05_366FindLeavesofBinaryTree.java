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
 *  注意点：当前node的高度是 1 + Max（height(node.left),height(node.right)）。leaf的高度是0
 *              The height of a node is also the its index in the result list (res).
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
public class A05_366FindLeavesofBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, root);
		return res;
	}

	//calculate the index of this root passed in and put it in that index, at last return where this root was put
	private int helper(List<List<Integer>> res, TreeNode node) {
		if (node == null) {
			return -1;
		}
		int left = helper(res, node.left);
		int right = helper(res, node.right);
		int cur = Math.max(left, right) + 1;
		// the first time this code is reached is when curr==0, since the tree is bottom-up processed.
		if (res.size() == cur) {
			res.add(new ArrayList<>());
		}
		res.get(cur).add(node.val);
		return cur;
	}

	/**
	 * if (list.size() == cur) {
	 *     list.add(new ArrayList<Integer>());
	 * }
	 * 这段代码为什么可以这么写？
	 * 因为通过跟踪递归可以发现，他的index都是连续的，没有跳跃写的情况，一般是这样：先0，再1，再2，再0，再1，再2，再3；不会出现先0，再2，再1，再4这样的情况
	 *
	 */

 	public static void main(String[] args) {
 		
	}
}
