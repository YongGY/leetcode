package tree.level;

import a0_common.TreeNode;

/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * 
 * @author William
 *
 * 题解：
 * 普通二叉树求公共祖先。看过<剑指Offer>以后知道这道题应该形成一系列问题。比如是不是二叉树，是不是BST。
 * 假如是BST的话我们可以用上题的方法，二分搜索。
 * 有没有指向父节点的link，假如有指向父节点的link我们就可以用intersection of two lists的方法找到两个linked list相交的地方。
 *
 * 对这道题目，我们使用后续遍历来做：
 * 		1.定义两个辅助节点，使用后续遍历来遍历整个树
 * 		2.当root的值等于p或者q时，找到一个符合条件的节点，返回这个root
 * 		3.先遍历左子树
 * 		4.再遍历右子树
 * 		5.当left，right均找到时返回此root
 * 		6.只找到left时返回left
 * 		7.只找到right时返回right
 * 		8.否则返回null
 *
 *
 * 	首先要先确定给的两个node是否都在tree里，如果都在tree里的话，就可以分成3种情况，
 * 	第一种情况是两个节点是在公共祖先的左右两侧，
 * 	第二种情况是都在树的左侧，
 * 	第三种情况是都在树的右侧，
 * 	如果是第二，第三种情况的话，公共祖先就在给定的两个点中比较上面的那一个。
 *
 * 	如果转换成代码的话，从上往下走，base case分为3种，
 * 	判断遇到了p就直接返回p，遇到q就直接返回q，不用向下做了。
 * 	如果left,right都不为空，就返回root自己；
 * 	left,right哪一个不为空就返回哪个，整个recursion做完就可以得到LCA。
 */
public class A236_LowestCommonAncestorofaBinaryTree {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		//如果 root 为空了，说明这条路径上不可能有 p 或 q 节点，返回空
		if (root == null) {
			return null;
		}

		//如果找到 p 或者 q 那么就没有必要接着递归，因为共同祖先只可能是[该节点]或[该节点祖先]
		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);    //往左分支上寻找
		TreeNode right = lowestCommonAncestor(root.right, p, q);  //往右分支上寻找

		if (left != null && right != null) {   //说明 p 和 q 是分布在 root 两侧，返回即可
			return root;
		} else {
			return left != null ? left : right;   //说明在 left 分支上找到 p 或 q 节点，返回即可 , 否则返回 right
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(0);
		TreeNode t7 = new TreeNode(8);
		TreeNode t8 = new TreeNode(7);
		TreeNode t9 = new TreeNode(4);

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;

		t5.left = t8;
		t5.right = t9;

		System.out.println(lowestCommonAncestor(t1,t2,t3));
		System.out.println(lowestCommonAncestor(t1,t2,t9));
		System.out.println(lowestCommonAncestor(t1,t6,t9));
	}
}
