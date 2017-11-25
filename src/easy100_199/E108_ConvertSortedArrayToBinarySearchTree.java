package easy100_199;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author William 
 * 
 * 题解：
 * 要求根据一个有序数组，构造出一棵高度平衡的BST。
 * 这道题是要将有序数组转为二叉搜索树，所谓二叉搜索树，是一种始终满足左<根<右的特性，如果将二叉搜索树按中序遍历的话，得到的就是一个有序数组了。
 * 那么反过来，我们可以得知，根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，在分别找出其中间点作为原中间点的左右两个子节点，这不就是是二分查找法的核心思想么。
 * 所以这道题考的就是二分查找法
 * 
 *         先复习下什么是二叉搜索树（引自Wikipedia）：
 *         二叉查找树（Binary Search Tree），也称有序二叉树（ordered binary tree）,排序二叉树（sorted
 *         binary tree），是指一棵空树或者具有下列性质的二叉树：
 * 
 *         若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
 *         任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *         任意节点的左、右子树也分别为二叉查找树。
 * 
 *         再复习下什么是平衡二叉树（引自GeekforGeek）：
 *         An empty tree is height-balanced. A non-empty binary tree T is
 *         balanced if: 
 *         1) Left subtree of T is balanced 
 *         2) Right subtree of T is balanced 
 *         3) The difference between heights of left subtree and
 *         right subtree is not more than 1.
 * 
 *         解决方法是选中点构造根节点，然后递归的构造左子树和右子树。
 *
 */
public class E108_ConvertSortedArrayToBinarySearchTree {

	/**
	 * Definition for a binary tree node.
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return buildTree(nums, 0, nums.length - 1);
	}

	public TreeNode buildTree(int[] nums, int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildTree(nums, low, mid - 1);
		node.right = buildTree(nums, mid + 1, high);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
