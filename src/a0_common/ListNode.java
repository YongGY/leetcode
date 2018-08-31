package a0_common;

/**
 * 
 * @author William
 *
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "[val=" + val + ", next=" + next + "]";
	}

}
