package tree.level;

import a0_common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
public class A105_ConstructBinaryTreefromPreorderandInorderTraversal {

//	// T(N)=O(N)+2T(N/2) ==> time O(nlogn)
//	// space O(N) + extra O(logn)

	/**
	 * https://blog.csdn.net/yanglingwell/article/details/79664725
	 * 根据前序遍历和中序遍历重建二叉树，方法是自顶向下recursive来构建。
	 * 前序是 root -> left -> right
	 * 中序是 left -> root -> right。
	 * 所以每次preorder[preLo]就是root。
	 *
	 * 接下来preorder[preLo + 1] 就是当前root的left child，
	 * 接下来在inorder中找到root的index : rootAtInorder，则 inorder[rootAtInOrder + 1]就是当前root的right child。
	 *
	 * 最后做递归的时候要注意，求left child时，inHi = rootAtInOrder - 1，求right child时， inLo = rootAtInOrder + 1。
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0)
			return null;
		return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static TreeNode dfs(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
		if(preLo > preHi || inLo > inHi) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preLo]);

		int rootAtInorder = 0;
		for(int i = inLo; i <= inHi; i++) {
			if(inorder[i] == root.val) {            //because no duplicate
				rootAtInorder = i;
				break;
			}
		}

		int leftSubTreeLen = rootAtInorder - inLo;
		root.left = dfs(preorder, preLo + 1, preLo + leftSubTreeLen, inorder, inLo, rootAtInorder - 1);
		root.right = dfs(preorder, preLo + leftSubTreeLen + 1, preHi, inorder, rootAtInorder + 1, inHi);
		return root;
	}

	public static void main(String[] args) {
 		System.out.println(buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
	}

}
