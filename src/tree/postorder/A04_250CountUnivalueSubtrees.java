package tree.postorder;

import common.TreeNode;

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
 * subtree就是指，在一个tree里的某一个node，以及这个node的所有descendants.
 *
 * 那么从题目给的例子里，我们复合条件的subtree有4个；
 * 左边第三层里的两个"5"算其2， 右边第二层的"5 - 5"，以及第三层的"5"也都算符合条件的subtree，所以我们返回4。
 * 要注意root节点及右边第二层和第三层一起组成的"5-5-5"并不是subtree，这只能算一条root-to-leaf path。
 *
 * 另外我们再看一个例子[1, 2, 3]，这里作为leaf节点的2和3也分别都是符合条件的subtree，我们返回2。
 * 其实所有的leaf节点都是符合条件的。
 * 所以我们这道题的处理方法和https://leetcode.com/problems/balanced-binary-tree/ 有点像，都是自底向上进行判断。
 *
 * 1.这里我们先创建一个Global变量count， 也可以不用global变量而使用一个size为数组作为参数传递进辅助函数isUnival中。
 *
 * 2.isUnival主要就是递归地自底向上判断tree是否为unival,也就是所有节点值均相等。有下面几种情况需要考虑
 *
 * 		1.root = null,这时候我们返回true。递归终止时，每个leaf节点都为true，所以null情况我们返回true
 * 		2.当左子树为unival并且右子树也为unival的时候
 * 			2.1 假如左右子节点都为空，则我们遇到leaf节点，合理，count++
 * 			2.2 假如左子节点或者右子节点不为空，但值又不与root的值相等时，root本身加左右子树形成的这个subtree不满足题意，我们返回false
 * 			2.3 否则，root及其descendants形成一个满足题意的subtree，我们把count++，记录下这个subtree
 * 		3.要注意判断左右子树是否为unival的时候，左子树和右子树都要判断，这里我们使用了一个'&'符号来避免短路条件判断。也可以分开写。
 *
 * Time Complexity - O(n)， Space Complexity - O(n).
 */
public class A04_250CountUnivalueSubtrees {
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		isUnival(root);
		return count;
	}

	private boolean isUnival(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (isUnival(node.left) & isUnival(node.right)) {
			if (node.left != null && node.left.val != node.val) {
				return false;
			}
			if (node.right != null && node.right.val != node.val) {
				return false;
			}
			count++;
			return true;
		}
		return false;
	}
    
 	public static void main(String[] args) {
 		
	}
}
