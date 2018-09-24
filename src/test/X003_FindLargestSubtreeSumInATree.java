package test;

import a0_common.TreeNode;

public class X003_FindLargestSubtreeSumInATree {
	// http://massivealgorithms.blogspot.com/2016/12/maximum-sum-subtree.html

	// http://standalone.iteye.com/blog/1680541
	
	/**
	 * Given a binary tree, task is to find subtree with maximum sum in tree.
	 *  
	 *  Examples :
	 *  
	 *  Input :       1
	 *              /   \
	 *             2      3
	 *            / \    / \
	 *           4   5  6   7
	 *  Output : 28
	 *  As all the tree elements are positive,
	 *  the largest subtree sum is equal to
	 *  sum of all tree elements.
	 *  
	 *  Input :       1
	 *              /    \
	 *            -2      3
	 *            / \    /  \
	 *           4   5  -6   2
	 *  Output : 7
	 *  Subtree with largest sum is :  -2
	 *                               /  \ 
	 *                              4    5
	 *  Also, entire tree sum is also 7.
	 */
	int sumOfTree(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		int leftR = sumOfTree(root.left, max);
		int rightR = sumOfTree(root.right, max);
		int sum = leftR + rightR + root.val;
		if (sum > max) {
			max = sum;
		}
		return sum;
	}
	
	
	//========================下面应该是对的==========
	
	
	class Result {
		int value;
		TreeNode node;

		Result(int val, TreeNode node) {
			this.value = val;
			this.node = node;
		}
	}

	int sumOfTree(TreeNode root, Result max) {
		if (root == null) {
			return 0;
		}
		int leftR = sumOfTree(root.left, max);
		int rightR = sumOfTree(root.right, max);
		int sum = leftR + rightR + root.val;
		if (sum > max.value) {
			max.value = sum;
			max.node = root;
		}
		return sum;
	}


	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.left = t6;
		t3.right = t7;
		
		TreeNode t11 = new TreeNode(1);
		TreeNode t21 = new TreeNode(-2);
		TreeNode t31 = new TreeNode(3);
		TreeNode t41 = new TreeNode(4);
		TreeNode t51 = new TreeNode(5);
		TreeNode t61 = new TreeNode(-6);
		TreeNode t71 = new TreeNode(2);
		
		t11.left = t21;
		t11.right = t31;
		
		t21.left = t41;
		t21.right = t51;
		
		t31.left = t61;
		t31.right = t71;

 //		B003 b = new B003();
//		Result r = b.new Result(Integer.MIN_VALUE, t1);
//		Result r1 = b.new Result(Integer.MIN_VALUE, t11);
//		System.out.println(b.sumOfTree(t1, r));
//		System.out.println(b.sumOfTree(t11, r1));
	}
}
