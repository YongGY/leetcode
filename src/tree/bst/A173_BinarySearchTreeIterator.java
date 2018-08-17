package tree.bst;

import java.util.Stack;

import a0_common.TreeNode;

/**
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 * @author William
 *
 *
 * 思路：
 * 		这题是要快速求一个二叉搜索数是否有下一个最小结点。
 * 		我们知道二叉搜索数的性质，结点左边的值比根节点小，结点右边的值比根节点大。
 * 		那么利用这个性质可以知道最小的结点应该是在最左边，其实也就是中序遍历是依次增大的。
 * 		知道了这样我们其实可以利用一个栈将所有结点按照: 根->右结点->左节点的方式入栈然后再依次出栈即可。
 * 		这样在时间复杂度上可以达到O(1)，但空间复杂度是O(n)，ｎ为结点个数。这样不符合要求的O(h)的时间复杂度。
 *
 * 		我们还可以初始只让根的左子树入栈直到最左结点，每次结点出栈的时候再把他的右子树入栈，这样就可以达到O(h)的时间复杂度。
 * 		举个栗子：
 *
 *				         4
 *
 *				    2         7
 *
 *				 1    3     6   8
 *
 * 		这样一个二叉搜索树，先依次让4->2->1入栈，每次调用next函数则让一个元素出栈。
 *
 * 		第一次调用next的时候１出栈。
 *
 * 		第二次调用next的时候２出栈，因为２有右子树，因此让２的右子树３入栈
 *
 * 		第三次调用next的时候３出栈
 *
 * 		第四次调用next的时候４出栈，并且４有右子树，但是此时４的右子树并不是最小结点，他还有左子树，因此一直遍历到左子树的叶子结点，依次入栈。
 *
 * 		重复以上操作即可。
 *
 * 		平均时间复杂度还是O(1)，空间复杂度降为O(h)。
 *
 *
 */
public class A173_BinarySearchTreeIterator {

	private Stack<TreeNode> stk;

	class BSTIterator {

		public BSTIterator(TreeNode root) {
			stk = new Stack<>();
			// 先找到第一个节点，并把路径入栈
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			// 栈为空时不再有下一个
			return !stk.isEmpty();
//			return stk.size() != 0;
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			TreeNode curr = stk.pop();
			TreeNode node = curr.right;   // 如果该元素有右节点，把它的右节点及右节点的所有左边节点都压入栈中
			while (node != null) {
				stk.push(node);
				node = node.left;
			}
			return curr.val;
		}

//		public Stack aa() {
//			return stk;
//		}
	}

	 /**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	  *
	 *       4
	 *      / \
	 *     1   5
	 *      \   \
	 *      3    7
	 *     /    /
	 *    2    6
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(6);

		BSTIterator iterator = new A173_BinarySearchTreeIterator().new BSTIterator(root);

//		System.out.println(iterator.aa());

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
