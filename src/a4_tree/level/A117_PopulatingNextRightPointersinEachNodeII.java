package a4_tree.level;

import a0_common.TreeLinkNode;

/**
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * 
 * @author William
 *
 */
public class A117_PopulatingNextRightPointersinEachNodeII {

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		// now find root.next's valid child
		TreeLinkNode n = root.next;
		TreeLinkNode nextNodeChild = null;
		while (n != null && nextNodeChild == null) {
			if (n.left != null) {
				nextNodeChild = n.left;
				break;
			}
			if (n.right != null) {
				nextNodeChild = n.right;
				break;
			}
			n = n.next;
		}
		// now nextNodeChild is fetched
		if (root.right != null) {
			root.right.next = nextNodeChild;
		}
		if (root.left != null) {
			root.left.next = root.right == null ? nextNodeChild : root.right;
		}
		// recursion call
		connect(root.right);
		connect(root.left);
	}

	/**
	 * 思路2： Iteration - use dummy node to keep record of the next level's root to refer
	 *              pre travel current level by referring to root in the level above
	 * Complexity: time O(N) space O(1)
	 */
	public void connect1(TreeLinkNode root) {
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode pre = dummy;//record next root
		while(root != null){
			if(root.left != null){
				pre.next = root.left;
				pre = pre.next;
			}
			if(root.right != null){
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;//reach end, update new root & reset dummy
			if(root == null){
				root = dummy.next;
				pre = dummy;
				dummy.next = null;
			}
		}
	}


 	public static void main(String[] args) {
 		
	}
}
