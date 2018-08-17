package tree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import a0_common.TreeNode;

/**
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author William
 *
 * The key to to iterative postorder traversal is the following:
 *
 * The order of "Postorder" is: left child -> right child -> parent node.
 * Find the relation between the previously visited node and the current node
 * Use a stack to track nodes
 * As we go down the tree to the lft, check the previously visited node.
 * If the current node is the left or right child of the previous node, then keep going down the tree, and add left/right node to stack when applicable.
 * When there is no children for current node, i.e., the current node is a leaf, pop it from the stack.
 * Then the previous node become to be under the current node for next loop.
 * You can using an example to walk through the code.
 *
 */
public class A145_BinaryTreePostorderTraversal {


	/**
	 * DFS
	 * #### Recursive
	 * trivial, 先加left recursively, 再加right recursively, 然后组成头部.
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}

	public static void dfs(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		dfs(node.left, res);
		dfs(node.right, res);
		res.add(node.val);
	}

	
	/**
	 * ##### 利用stack的特点
	 * - 每次加element进stack的时候, 想要在 bottom/后process的, 先加
	 * - 想要下一轮立刻process的, 最后push进stack.
	 */
	public static List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if(root == null){
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.empty()){
			TreeNode node = stack.pop();
			res.add(0,node.val);

			if(node.left != null){
				stack.push(node.left);
			}

			if(node.right != null){
				stack.push(node.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right =  t5;

		t3.right = t6;

		System.out.println(postorderTraversal(t1));
//		System.out.println(postorderTraversal1(t1));
 	}

}
