package questions;

import java.util.ArrayList;
import java.util.List;

import a0_common.TreeNode;

public class N006 {

	/**
	 * 
			       1
			     /    \
			    2     3
			   / \    / \
			  4  5 	  6  7 
			 
			find weight of all elements such that weight =sum of(product of all the traversal path through node)
			 
			for ex consider 2  find all path traversing through 2 {1,2,4} and {1,2,5}
			weight(2) = (1*2*4) +(1*2*5)  =  8+10 = 18
			weight(3) = (1*3*6) + (1*3*7) = 18+21 = 39
 
	 *
	 */
	
	
 	
	public static int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	private static int dfs(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		System.out.println(sum +"  --------------   "+node.val);
		sum = sum  + node.val;
		if (node.left == null && node.right == null) {
			System.out.println(sum);
			return sum;
		}
		return dfs(node.left, sum) + dfs(node.right, sum);
	}
	
	
	
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		dfs(root, "", res);
		return res;
	}

	private static void dfs(TreeNode root, String tmp, List<String> res) {
		if (root == null) {
			return;
		}
		if(){
			
		}
		if (root.left == null && root.right == null) {
			res.add(tmp + root.val);
		}
		dfs(root.left, tmp + root.val + "->", res);
		dfs(root.right, tmp + root.val + "->", res);
	}

	
	 
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;
// 		System.out.println(sumNumbers(t1));
 		System.out.println(binaryTreePaths(t1));
	}
    
}