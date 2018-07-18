package difficulty.easy200_399;

/**
	Invert a binary tree.
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		
	to
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1.
 */

 public class E226_InvertBinaryTree_____Locked {
	

		/**
		 * Definition for a binary tree node.
		 */
		class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}
	 
		
	    public TreeNode invertTree(TreeNode root) {
			return root;
	        
	    }
}
