package tree.bst;

import common.TreeNode;

/**
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * @author William
 *
 */
public class A285_InorderSuccessorInBST {

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null) {
			return null;
		}
		TreeNode res = null;
		while(root != null) {
			// 如果是小于等于的值，就要往右移动
			if(root.val <= p.val) {
				root = root.right;
			}
			// 比root大的值都可能是successor，所以要保留
			else {
				res = root;
				root = root.left;
			}
		}
		return res;
	}


	//模板 [BST InOrder Successor / Predecessor]
	// successor
	public static TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val > p.val) { //利用BST性质
			TreeNode left = inorderSuccessor1(root.left, p);  //looking for p in the left subtree
			return left == null ? root : left;  //null case: when leftmost leaf
		} else {
			return inorderSuccessor1(root.right, p); //successor in the right subtree
		}
	}

	// Predecessor
	public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		if(root == null){ return root;}
		if(root.val>=p.val){//利用BST性质
			TreeNode left = inorderPredecessor(root.left,p);
			return left;
		}else{
			TreeNode right = inorderPredecessor(root.right,p);//右叶，打印中叶或root
			return right != null?right:root;
		}
	}

	/**
	 *         20
	 *       /    \
	 *     10      30
	 *    /  \    /  \
	 *   5   15  25  35
	 *   \   / \
	 *   7  13  18
	 */

//	public static void aaa(TreeNode root){
//		if(root == null){
//			return;
//		}
//		aaa(root.left);
//		System.out.println(root.val);
//		aaa(root.right);
//	}


	public static void main(String[] args) {
		//5, 7, 10, 13, 15, 18, 20, 25, 30, 35
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		root.left.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(18);
		System.out.println(inorderSuccessor(root, new TreeNode(30)));
		System.out.println(inorderSuccessor1(root, new TreeNode(30)));

	}
}
