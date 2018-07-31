package tree.level;

import common.TreeLinkNode;

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
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 * 
 * @author William
 *
 */
public class A08_116PopulatingNextRightPointersinEachNode {

//	题解：
//	这题需要在一棵完全二叉树中使用next指针连接旁边的节点，我们可以发现一些规律。
//	如果一个子节点是根节点的左子树，那么它的next就是该根节点的右子树譬如上面例子中的4，它的next就是2的右子树5。
//	如果一个子节点是根节点的右子树，那么它的next就是该根节点next节点的左子树。譬如上面的5，它的next就是2的next（也就是3）的左子树。

	/**
	 * 使用DFS。题目给出完全二叉树，所以只要先判断next节点是否为空，接下来判定root的左右子节点是否为空就可以了。
	 * 递归的Space Complexity怎么算？
	 * 这里建立了一个TreeLinkNode，是reference type，这个object的reference存在stack里，但object是存在heap里。  还要学习JVM的许多知识。
	 * Time Complexity - O(n)， Space Complexity - O(1).
	 */

	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null) {
			if (root.next != null)
				root.right.next = root.next.left;
			else
				root.right.next = null;
		}
		connect(root.left);
		connect(root.right);
	}


	public void connect2(TreeLinkNode root) {
		TreeLinkNode curLevel = new TreeLinkNode(-1);
		TreeLinkNode newLevel = curLevel;
		while (root != null) {
			if (root.left != null) {
				curLevel.next = root.left;
				curLevel = curLevel.next;
			}
			if (root.right != null) {
				curLevel.next = root.right;
				curLevel = curLevel.next;
			}
			root = root.next;
			if (root == null) {
				curLevel = newLevel;
				root = newLevel.next;
				newLevel.next = null;
			}
		}
	}


	/**
	 * 两层循环，当root和root.left不为空的时候，我们要利用好自己创建的next节点来不断向右进行遍历。
	 * 遍历完这一层以后我们可以设置root = root.left，这样我们到了下一层，继续向右进行遍历。
	 * Time Complexity - O(n)， Space Complexity - O(1)
	 */
	public void connect1(TreeLinkNode root) {

		TreeLinkNode node = null;

		// root.left != null如果不用，则处理到最后第一个没有左右子树的结点会出错
		while (root != null && root.left != null) {
			node = root;  // 每个root表示第一个层的第一个结点 ,node记录每一个层的第一个结点
			// 处理每个层
			while (node != null) {
				node.left.next = node.right; // 表示连接的是同一个结点的下的两子结点
				// node不是某个层的最后一个结点
				if (node.next != null) {
					node.right.next = node.next.left;  // 将这个结点的右子结点连接到这个结点的同层相邻结点的左子结点上
				}
				node = node.next; // 移动到同层的下一个结点
			}
			root = root.left;  // 移动到下一层的第一个结点
		}

	}

	public static void main(String[] args) {
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);

		t1.left =  t2;
		t1.right =  t3;

		t2.left =  t4;
		t2.right =  t5;

		t3.left = t6;
		t3.right = t7;
		connect(t1);
		System.out.println(t1);
	}
}
