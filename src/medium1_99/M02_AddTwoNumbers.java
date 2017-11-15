package medium1_99;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * 思路:
 * 有一个类型 是链表类型 结构如类ListNode 把两个给出的链表的val值相加 合并成一个链表. 
 * 例： Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 个位数为 2+5=7. 十位数为 4+6 =10，需要進位 ； 
 * 百位数为3+4+1(进位的)=8，结果为 7->0->8
 * 要注意的就是list1跟list2长度不同，另外就是相加可能比9大，考虑进位的情況
 * 
 * @author William
 * 
 */
public class M02_AddTwoNumbers {

	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0); // 储存输出的结果，因为list的指针要不断往后移，因此用一个假节点方便操作
		if (l1 == null && l2 == null) { //如果都为空 直接返回不为空的一个参数 如果都未空 则返回空  
			return dummyHead;
		}

		ListNode curr = dummyHead; // 使用一個ListNode来储存相加的结果
		int sum = 0;
		int carry = 0; //进位标示
		while (l1 != null || l2 != null) {
			// list1与list2长度可能不同，分开处理
			int num1 = (l1 == null ? 0 : l1.val);
			int num2 = (l2 == null ? 0 : l2.val);
			sum = num1 + num2 + carry;  // 如果之前有进位，carry = 1；沒有的话carry = 0
			curr.next = new ListNode(sum % 10); //取余 ，相加如果超过9，只能留下个位数放入結果list，十位数的地方进位
			curr = curr.next;  // list指针向后
			carry = sum / 10;  //取商后结果为进位数 
			
			//l1 和 l2 的指针进行步进，否则无限循环
			l1 = (l1 == null ? null : l1.next);
			l2 = (l2 == null ? null : l2.next);
		}
		//两条链表都遍历完的时候，carry 值可能不为 0
		if (carry != 0) {
			curr.next = new ListNode(carry);
		}
		///第一个节点为假节点，跳过
		return dummyHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M02_AddTwoNumbers m = new M02_AddTwoNumbers();
		ListNode l1= m.new ListNode(9);
		ListNode l1_1= m.new ListNode(4);
		ListNode l1_2= m.new ListNode(3);
		l1.next = l1_1;
		l1_1.next = l1_2;
		
//		
		ListNode l2= m.new ListNode(8);
		ListNode l2_1= m.new ListNode(6);
//		ListNode l2_2= m.new ListNode(4);
		l2.next = l2_1;
//		l2_1.next = l2_2;
		ListNode r = m.addTwoNumbers(l1,l2);
		System.out.println(r.val +"->"+ r.next.val+ "->" +r.next.next.val);
	}

}
