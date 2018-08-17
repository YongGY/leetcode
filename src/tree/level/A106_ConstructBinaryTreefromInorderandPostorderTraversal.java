package tree.level;

import a0_common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * @author William
 *
 */
public class A106_ConstructBinaryTreefromInorderandPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)
			return null;
		return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode dfs(int[] postorder, int postLo, int postHi, int[] inorder, int inLo, int inHi) {
		if(postLo > postHi || inLo > inHi)
			return null;
		TreeNode root = new TreeNode(postorder[postHi]);
		int rootAtInorder = 0;
		for(int i = inLo; i <= inHi; i++) {
			if(inorder[i] == root.val) {
				rootAtInorder = i;
				break;
			}
		}
		//注意递归的时候postorder的左子树范围是 [postLo, postLo + leftSubTreeLen - 1]， 右子树是[postLo+ leftSubTreeLen, postHi - 1]
		int leftSubTreeLen = rootAtInorder - inLo;
		root.left = dfs(postorder, postLo, postLo + leftSubTreeLen - 1, inorder, inLo, rootAtInorder - 1);
		root.right = dfs(postorder, postLo + leftSubTreeLen, postHi - 1, inorder, rootAtInorder + 1, inHi);
		return root;
	}
    
 	public static void main(String[] args) {
 		
	}
}
