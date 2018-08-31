package other;


public class StackTTT {
	
	class Node{
		int val;
		Node pre;
		public Node(int val) {
			this.val = val;
		}
	}
	
	Node head;
	Node curr;
	public void push(int val) {
		if(head == null) {
			head = new Node(val);
			curr =head;
		}else {
			Node node = new Node(val);
			node.pre = curr;
			curr = node;
		}
	}
	public int pop() throws Exception {
		if(curr == null) {
			
		}
		Node node = curr;
		curr = curr.pre;
		return node.val;
	}
	
	public boolean empty() {
		return curr == null;
 	}
	
    public static void main(String[] args) throws Exception {
    	StackTTT stack = new StackTTT();
		stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// System.out.println(stack.pop().val);
		// System.out.println(stack.pop().val);
		// System.out.println(stack.pop().val);
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.empty());

    }
}