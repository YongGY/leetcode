package tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author William
 *
 * http://www.voidcn.com/article/p-zllboida-brm.html
 *
 */
public class A103_BinaryTreeZigzagLevelOrderTraversal {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean order = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> tmpList = new ArrayList<>();
			for(int i=0; i < size; i++){
				TreeNode tmpNode = queue.poll();
				if(order){
					tmpList.add(tmpNode.val);
				}else{
					tmpList.add(0,tmpNode.val);
				}
				if(tmpNode.left!=null) queue.add(tmpNode.left);
				if(tmpNode.right!=null) queue.add(tmpNode.right);
			}
			order = order ? false : true;
			res.add(tmpList);
		}
		return res;
	}


	public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		List<TreeNode> q = new ArrayList<>();
		List<Integer> level = new ArrayList<>();
		if (root == null) {
			return result;
		}
		q.add(root);
		level.add(0);
		while (q.size() > 0) {
			TreeNode node = q.remove(0);
			int cl = level.remove(0);
			if (result.size() <= cl) {
				result.add(new ArrayList<>());
			}
			if (cl % 2 == 0) {
				result.get(cl).add(node.val);
			} else {
				result.get(cl).add(0, node.val);
			}
			if (node.left != null) {
				q.add(node.left);
				level.add(cl + 1);
			}
			if (node.right != null) {
				q.add(node.right);
				level.add(cl + 1);
			}
		}//while
		return result;
	}//zigzag


	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
//		TreeNode t6 = new TreeNode(8);

		t1.left =  t2;
		t1.right =  t3;

		t3.left =  t4;
		t3.right = t5;
//
//		t4.left = t6;
		System.out.println(zigzagLevelOrder(t1));
	}
}
