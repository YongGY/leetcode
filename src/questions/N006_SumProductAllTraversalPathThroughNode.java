package questions;


public class N006_SumProductAllTraversalPathThroughNode {

	/**
	 * 
			       11
			     /   \
			    2     3
			   / \   / \
			  4  5 	 6  7 
			 /\
			8  9
			find weight of all elements such that weight =sum of(product of all the traversal path through node)
			 
			for ex consider 2  find all path traversing through 2 {1,2,4} and {1,2,5}
			weight(2) = (1*2*4) +(1*2*5)  =  8+10 = 18
			weight(3) = (1*3*6) + (1*3*7) = 18+21 = 39
 weight(2) = 1*2*4*8 +  1*2*4*9 + 1*2*5 = 64 + 72 + 10 = 146
 weight(4) = 1*2*4*8 +  1*2*4*9 = 64 + 72 = 136
	 *
	 */
	
	//11*2*4 + 11*2*5 = 88+ 110 = 198
	//(2*4)+(2*5) * 11 = 16*11
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(int x) {
			val = x;
		}
	}

	
	
	
	static int sumPval = 1;
	public static int weight(TreeNode root) {
		if(root == null){
			return 0;
		}
		//int sumPval = weightUp(root);
		sumPval = weightUp(root);
		return weightSum(root);
	}
	
	public static int weightUp(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.parent == null){
			return 1;
		}
		else{
			return root.parent.val * weightUp(root.parent);
		}
	}

	public static int weightSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		} else {
//			return root.val * weightSum(root.left, sumPval) * sumPval
//					+ root.val * weightSum(root.right, sumPval) * sumPval;
			return root.val * weightSum(root.left) * sumPval
					+ root.val * weightSum(root.right) * sumPval;
		}
	}
	
	
	 
	public static void main(String[] args) {
		N006_SumProductAllTraversalPathThroughNode s = new N006_SumProductAllTraversalPathThroughNode();
		TreeNode t1 = s.new TreeNode(11);
		TreeNode t2 = s.new TreeNode(2);
		TreeNode t3 = s.new TreeNode(3);
		t2.parent = t1;
		t3.parent = t1;
		TreeNode t4 = s.new TreeNode(4);
		TreeNode t5 = s.new TreeNode(5);
		t4.parent = t2;
		t5.parent = t2;
		TreeNode t6 = s.new TreeNode(6);
		TreeNode t7 = s.new TreeNode(7);
		t6.parent = t3;
		t7.parent = t3;
//		TreeNode t8 = s.new TreeNode(8);
//		TreeNode t9 = s.new TreeNode(9);
//		t8.parent = t4;
//		t9.parent = t4;
		
		

		t1.left =  t2;
		t1.right =  t3;

		t2.left = t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;
		
//		t4.left = t8;
//		t4.right = t9;
//		System.out.println(weight(t4));
// 		System.out.println(weightUp(t4));
 		System.out.println(weight(t2));
 	}
    
}