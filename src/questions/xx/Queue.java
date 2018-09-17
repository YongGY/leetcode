package questions.xx;

public class Queue {
	public Node head;
	public Node curr;

	// 方法：链表中添加结点
	public void push(int val) {
		if (head == null) {
			head = new Node(val);
			curr = head;
		} else {
			curr.next = new Node(val);
			curr = curr.next;
		}
	}

	// 方法：出队操作
	public int pop() throws Exception {
		if (head == null) {
			throw new Exception("队列为空");
		}
		Node node = head; // node结点就是我们要出队的结点
		head = head.next; // 出队之后，head指针向下移
		return node.val;
	}

	class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		// 入队操作
		for (int i = 0; i < 5; i++) {
			queue.push(i);
		}
		// 出队操作
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
