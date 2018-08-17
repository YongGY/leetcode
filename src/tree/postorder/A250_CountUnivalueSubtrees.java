package tree.postorder;

import a0_common.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 *
 * return 4.
 * 
 * @author William
 *
 * 注意判断两个子树是否都为Uni-value subtree的时候用了 '&'，这样才能判断两个条件，否则第一个条件为false时就不判断第二个了。
 *
 * 要做这道题我们首先要看清楚例子，以及弄明白什么是subtree。
 * subtree就是指，在一个tree里的某一个node，还有这个node的所有descendants.
 *
 * 那么从题目给的例子里，我们复合条件的subtree有4个；
 * 左边第三层里的两个"5"算其2， 右边第二层的"5 - 5"，以及第三层的"5"也都算符合条件的subtree，所以我们返回4。
 * 要注意root节点及右边第二层和第三层一起组成的"5-5-5"并不是subtree，这只能算一条root-to-leaf path。
 *
 * 另外我们再看一个例子[1, 2, 3]，这里作为leaf节点的2和3也分别都是符合条件的subtree，我们返回2。
 * 其实所有的leaf节点都是符合条件的。
 *
 */
public class A250_CountUnivalueSubtrees {

	public static int countUnivalSubtrees(TreeNode root) {
		int[] count = new int[1];
		dfs(root, count);
		return count[0];
	}

	private static boolean dfs(TreeNode node, int[] count) {
		if (node == null) {
			return true;
		}
		boolean left = dfs(node.left, count);
		boolean right = dfs(node.right, count);
		if (left && right) {
			if (node.left != null && node.val != node.left.val) {
				return false;
			}
			if (node.right != null && node.val != node.right.val) {
				return false;
			}
			count[0]++;
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(5);

		t1.left =  t2;
		t1.right =  t3;

		System.out.println(countUnivalSubtrees(t1));
	}
}
