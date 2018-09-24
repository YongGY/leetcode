package test;

public class Stack {

    public Node head;
    public Node curr;


    //方法：入栈操作
    public void push(int val) {
        if (head == null) {
            head = new Node(val);
            curr = head;
        } else {
            Node node = new Node(val);
            node.pre = curr;//current结点将作为当前结点的前驱结点
            curr = node;  //让current结点永远指向新添加的那个结点
        }
    }

    public int pop() throws Exception {
    	if (curr == null) {
            throw new Exception("空");
    	}
        Node node = curr; // current结点是我们要出栈的结点
        curr = curr.pre;  //每出栈一个结点后，current后退一位
        return node.val;

    }
    public int top() throws Exception {
    	if (curr == null) {
            throw new Exception("空");
    	}
    	return curr.val; // current结点是我们要出栈的结点
    }

    public boolean empty() {
    	return curr == null;
    }

    class Node {
        int val;
        Node pre;  //我们需要知道当前结点的前一个结点

        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) throws Exception {

		Stack stack = new Stack();
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