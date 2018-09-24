package test;

import a0_common.ListNode;
import a0_common.TreeNode;

public class W007_ConvertSortedListToBinarySearchTree {

	
	/**
	 * 	109. Convert Sorted List to Binary Search Tree
	 *  
	 *  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 *  
	 *  For this problem, 
	 *  a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	 *  
	 *  Example:
	 *  
	 *  Given the sorted linked list: [-10,-3,0,5,9],
	 *  
	 *  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	 *  
	 *        0
	 *       / \
	 *     -3   9
	 *     /   /
	 *   -10  5
	 * 	 
	 * https://segmentfault.com/a/1190000003816154
	 */
	
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
        	return null;
        }
        return toBST(head, null);
    }
    
    private TreeNode toBST(ListNode head, ListNode tail){
        if (head == tail) {
        	return null;
        }
		// 申请两个指针，fast移动速度是low的两倍
		ListNode fast = head;
		ListNode slow = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

}