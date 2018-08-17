package tree.level;

import java.util.*;

import a0_common.TreeNode;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * return its vertical order traversal as:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 *
 *
 * Given binary tree [3,9,20,4,5,2,7],
 *
 *     _3_
 *    /   \
 *   9    20
 *  / \   / \
 * 4   5 2   7
 *
 *
 * return its vertical order traversal as:
 *
 * [
 *   [4],
 *   [9],
 *   [3,5,2],
 *   [20],
 *   [7]
 * ]
 * 
 * @author William
 *
 */
public class A314_BinaryTreeVerticalOrderTraversal {

	/**
	 * 思路：用BFS来travese树，原因是要从上往下打印。
	 * 建2个Queue，第一个queue存node，第二个存对应的距离。往左就是dist-1，往右就是dist+1。用HashMap在相应的距离存下node。<dist,path>
	 * 最后将HashMap由key小到大加入list，即从左打到右-TreeMap(or HashMap记录key的min和max)
	 * Complexity: O(N) time O(N) space
	 *
	 * 关键字：BFS, two queue
	 */

	public static  List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> dist = new LinkedList<>();
		Map<Integer,List<Integer>> map = new HashMap <>();//<dist, path>

		nodes.offer(root);
		dist.offer(0);

		int min = 0;
		int max = 0;

		while(!nodes.isEmpty()){
			TreeNode cur = nodes.poll();
			int curdis = dist.poll();
			if(!map.containsKey(curdis)){
				map.put(curdis,new ArrayList<>());
			}
			map.get(curdis).add(cur.val);
			
			if(cur.left != null){
				nodes.offer(cur.left);
				dist.offer(curdis - 1);
				min = Math.min(curdis - 1, min);
 			}
			if(cur.right != null){
				nodes.offer(cur.right);
				dist.offer(curdis + 1);
				max = Math.max(curdis + 1, max);
			}
		}

		for(int i = min; i <= max; i++){
			res.add(new ArrayList(map.get(i)));
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(7);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;
		System.out.println(verticalOrder(t1));
	}

}
