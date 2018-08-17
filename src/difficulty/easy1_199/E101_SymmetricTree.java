package difficulty.easy1_199;

import a0_common.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
 * Note:Bonus points if you could solve it both recursively and iteratively
 * 
 * @author William
 *
 */
public class E101_SymmetricTree {
	 
	
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
		return isSymmetric(root.left, root.right);
        
    }    
    public boolean isSymmetric(TreeNode left,TreeNode right) {
    	if(left == null && right == null) {
    		return true;
    	}
    	if(left == null || right == null) {
    		return false;
    	}
    	if(left.val != right.val) {
    		return false;
    	}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
