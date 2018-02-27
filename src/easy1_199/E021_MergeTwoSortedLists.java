package easy1_199;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author yongguo
 *
 */
public class E021_MergeTwoSortedLists {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new E021_MergeTwoSortedLists().new ListNode (0);
        ListNode curr = dummy; //lastNode向了dummy的头
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1; //把小的值留下，留在在lastNode.next，lastNode指向L1(头) 或 lastNode.next 就是l1的头
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        
        return dummy.next;
	}
	

	
		
	public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
	
		if (l1 == null) return l2;
        if (l2 == null) return l1;
 
        if (l1.val > l2.val) {
            ListNode tmp = l2;
            tmp.next = mergeTwoLists(l1, l2.next);
            return tmp;
        } else {
            ListNode tmp = l1;
            tmp.next = mergeTwoLists(l1.next, l2);
            return tmp;
        }
	}
	
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E021_MergeTwoSortedLists e = new E021_MergeTwoSortedLists();
		ListNode l1 = e.new ListNode(1);
		ListNode l12 = e.new ListNode(2);
		ListNode l14 = e.new ListNode(4);
		l1.next = l12;
		l12.next = l14;
		
		ListNode l2 = e.new ListNode(3);
 		
		
		ListNode a = mergeTwoLists(l1,l2);
 		while(a.next != null){
 			System.out.println(a.val);
			a = a.next;
		}
		 
	}

}
