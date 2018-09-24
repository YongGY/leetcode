package test;

import a0_common.TreeNode;

public class X002_FindLargestSumForSubtree {

	
	/**
	 *  Given a binary tree, find the largest sum for a subtree.  
	 *  E.g. Given a tree shown below, the largest sum of this tree is sum([2,4,9]) = 15. 
	 *  And how to test it.
 
               -200
   			2         5
		4     9    -1    10
		
	 * @param args
	 */
	
	int maxSum = Integer.MIN_VALUE;
	public int maxSubtree(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftSum = maxSubtree(root.left);
		int rightSum = maxSubtree(root.right);
	 
		int sum = root.val + leftSum + rightSum;
		maxSum = Math.max(maxSum , sum);
		return sum;
	}
	
	public static void main(String[] args) {
		X002_FindLargestSumForSubtree a = new X002_FindLargestSumForSubtree();
		TreeNode root = new TreeNode(-200);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(9);
		
 		root.right.left = new TreeNode(-1);
		root.right.right = new TreeNode(10);
		
		a.maxSubtree(root);
		System.out.println(a.maxSum);
	}

}
