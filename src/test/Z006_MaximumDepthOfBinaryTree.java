package test;

import a0_common.TreeNode;

public class Z006_MaximumDepthOfBinaryTree {

	// 104. Maximum Depth of Binary Tree
	// 最大
	public int treeHeight(TreeNode root) {
		if (root == null){
			return 0;
		}
		return (1 + Math.max(treeHeight(root.left), treeHeight(root.right)));
	}
	
	
	//最小
    public int minDepth(TreeNode root) {
        return helper(root);
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == 0)  //no left-subtree, return right
            return right + 1;
        else if(right == 0)  //no right subtree, return leftt
            return left + 1;
        return Math.min(left, right) + 1;
    }
}
