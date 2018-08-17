package tree.postorder;

import common.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * 
 * @author William
 *
 */
public class A124_BinaryTreeMaximumPathSum {


	/**
	 * 问题解析：
	 * 给二叉树，寻找二叉树中从一个节点到任意一个节点的路径和的最大值。
	 *
	 * 对于本题，路径指的是从任意起始节点出发沿着父亲-孩子链接到达某个终止节点的节点序列。路径不一定要穿过根节点。题目中的“路径”中的任意节点只能出现一次。
	 *
	 * 解答：
	 * 我们以递归的思想，深度优先，从下到上寻找最大的路径和；
	 * 对于每个节点可以与其左右节点相结合，但是当每个根结点作为左（右）子节点返回时，只能选择该根根结点和其左右子节点中的最大的一个。（这样才能称为路径）
	 *
	 * 思路：
	 * 递归来看，如果只是一个节点,那么当然就是这个节点的值了。
	 * 如果这个作为root,那么最长路应该就是F(left) + F(right) + val。
	 * 当然如果left < 0 或者 right < 0 就不用加。
	 * 我们从下往上找，如果不这个不是root,那么就不能把left和right加起来了，因为只是一条路。
	 */


	/**
	 * 题意：求一个二叉树的一条最大路径和，这条路径可以从任意节点起始，到任意节点结束，但至少要有一个节点。
	 *
	 * 思路：
	 * 如例子，路径总共有三种类型：[1,2]，[1,3]，[2,1,3]。
	 * 即每个节点可以连接它的左边一条最大路径，或连接右边一条最大路径，或把左右最大路径连接起来。
	 * 因此我想到，用一个方法求以当前节点为起始节点，到它下方任意节点为终点的最长路径。
	 * 通过这个方法可以求一个节点左右的最长路径和，然后和这个节点值相加，就是以这个节点作为顶点的最大路径。
	 * 遍历树中所有节点，就可以找到最大的路径和。
	 */
	static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		dfs(root);
		return max;
	}

	//Path pass parent node only once at every node, either add its left or right path or nth for n
	private static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lmax = Math.max(0, dfs(root.left));        // left single path (左边一支儿（不算自己）)
		int rmax = Math.max(0, dfs(root.right));       // right single path
		max = Math.max(max, lmax + rmax + root.val);   // compare combo max with global max (穿过自己)
		return root.val + Math.max(lmax, rmax);        // always return the max single continuous path //（算上自己 update结果）
	}


//
//	public int maxPathSum(TreeNode root) {
//		int[] res = new int[1];
//		res[0] = Integer.MIN_VALUE;
//		return maxPath(root, res);
//
//	}
//	private int maxPath(TreeNode root, int[] res) {
//		if (root == null)
//			return;
//		int left = maxPath(root.left, res);//左边一支儿（不算自己）
//		int right = maxPath(root.right, res);
//		int arch = left + right + root.val; //穿过自己
//		int single = Math.max(root.val, Math.max(left, right) + root.val);
//		//（算上自己）
//		res[0] = Math.max(res[0], Math.max(arch, single));//update结果
//		return res[0];
//	}

	public static void main(String[] args) {
//		TreeNode t1 = new TreeNode(-10);
//		TreeNode t2 = new TreeNode(9);
//		TreeNode t3 = new TreeNode(20);
//		TreeNode t4 = new TreeNode(15);
//		TreeNode t5 = new TreeNode(7);
//
//		t1.left =  t2;
//		t1.right =  t3;
//
//
//		t3.left =  t4;
//		t3.right = t5;
//
//		System.out.println(maxPathSum(t1));

		TreeNode t11 = new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t31 = new TreeNode(3);

		t11.left =  t21;
		t11.right =  t31;
		System.out.println(maxPathSum(t11));

	}
}
