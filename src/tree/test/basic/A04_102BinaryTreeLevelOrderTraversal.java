package tree.test.basic;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author William
 *
 */
public class A04_102BinaryTreeLevelOrderTraversal {


	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root,0,res);
		return res;
	}

	public static void dfs(TreeNode root,int level ,List<List<Integer>> res){
		if(root == null){
			return ;
		}
		//if (result.size() < level + 1) {// 说明还需要添加一行
		if(res.size() == level){
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		dfs(root.left,level+1,res);
		dfs(root.right,level+1,res);
	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;

		t3.left = t4;
		t3.right = t5;

		System.out.println(levelOrder(t1));

	}

	/**
	 * 经常会出现类似如果你看到时钟上面的时间是X：Y，那么其时针和分针之间的角度是多少？
	 *
	 * 首先计算X小时Y分是多少小时，即X.（Y/60）小时。例如3:15就等于（3+15除以60）小时即3.25小时。
	 *
	 * 然后将结果除以12，得出来所占的比例，然后再乘以360度，得到小时的角度。
	 *
	 * 同理，将Y/60得到分钟所占的比例，然后乘以360得到分钟的角度。
	 *
	 * 然后两者相减。
	 *
	 * 例如
	 *
	 * Google面试题 如果你看到时钟上面的时间是3：15，那么其时针和分针之间的角度是多少？
	 * (（3+15/60）/12)*360-(15/60)*360=7.5度
	 */
}
