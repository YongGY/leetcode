package questions.xx;

import a0_common.ListNode;
import a0_common.TreeNode;

public class A007_ConvertSortedListToBinarySearchTree {

	
	/**
	 * 	109. Convert Sorted List to Binary Search Tree
	 *  
	 *  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 *  
	 *  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
	
    ListNode curr;
    
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        int len = 0;
        // 先计算出链表的长度
        while(head != null){
            head = head.next;
            len++;
        }
        // 开始建树
        return buildTree(0, len - 1);
    }
    
    private TreeNode buildTree(int start, int end){
        // 如果start>end，说明子树已经小到没有节点了，直接返回null
        if(start > end){
            return null;
        }
        // 找到中点
        int mid = start + (end - start) / 2;
        // 先递归的计算左子树
        TreeNode left = buildTree(start, mid - 1);
        // 然后建立根节点
        TreeNode root = new TreeNode(curr.val);
        // 链表顺序遍历
        curr = curr.next;
        // 最后计算右子树
        TreeNode right = buildTree(mid + 1, end);
        // 将三个节点连接起来
        root.left = left;
        root.right = right;
        return root;
    }
    
    
    
    
//    
//	public TreeNode sortedListToBST1(ListNode head) {
//		return toBST(head, null);
//	}
// 
//	private TreeNode toBST(ListNode head, ListNode tail) {
//		if (head == tail)
//			return null;
//		// 申请两个指针，fast移动速度是low的两倍
//		ListNode fast = head;
//		ListNode slow = head;
//		while (fast != tail && fast.next != tail) {
//			fast = fast.next.next;
//			slow = slow.next;
//		}
//		TreeNode root = new TreeNode(slow.val);
//		root.left = toBST(head, slow);
//		root.right = toBST(slow.next, tail);
// 
//		return root;
//	}
	
	
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
	
	
	// Convert Sorted Array to Binary Search Tree

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        // 先递归的计算左子树
        TreeNode left = buildTree(nums, start, mid - 1);
        // 创造根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 最后递归的计算右子树
        TreeNode right = buildTree(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
	

}