import java.util.*;

/**
 * Max Stack
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty
 */
public class MaxStack {
	private class DoubleLinkedList {
		Node head, tail;

		public DoubleLinkedList() {
			this.head = new Node(0);
			this.tail = new Node(0);
			this.head.next = tail;
			this.tail.prev = head;
		}

		public Node add(int val) {
			Node node = new Node(val);
			Node last = tail.prev;
			// adjust node
			node.next = this.tail;
			node.prev = last;
			// adjust tail
			tail.prev = node;
			// adjust last
			last.next = node;
			return node;
		}

		public int pop() {
			return remove(this.tail.prev).val;
		}

		public int last() {
			return this.tail.prev.val;
		}

		public Node remove(Node node) {
			Node next = node.next;
			Node prev = node.prev;
			// adjust prev
			prev.next = next;
			// adjust next
			next.prev = prev;
			// adjust node
			node.prev = node.next = null;
			return node;
		}
	}

	private class Node {
		int val;
		Node prev, next;

		public Node(int v) {
			this.val = v;
		}
	}

	private TreeMap<Integer, List<Node>> map;
	private DoubleLinkedList dll;

	public MaxStack() {
		this.map = new TreeMap<>();
		this.dll = new DoubleLinkedList();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		Node node = this.dll.add(x);
		this.map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
	}

	/**
	 * Remove the element on top of the stack and return it.
	 */
	public int pop() {
		int val = this.dll.pop();
		List<Node> l = this.map.get(val);
		l.remove(l.size() - 1);
		if (l.isEmpty()) {
			this.map.remove(val);
		}
		return val;
	}

	/**
	 * Get the element on the top.
	 */
	public int top() {
		return this.dll.last();
	}

	/**
	 * Retrieve the maximum element in the stack.
	 */
	public int peekMax() {
		return this.map.lastKey();
	}

	/**
	 * Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
	 */
	public int popMax() {
		int max = peekMax();
		List<Node> l = this.map.get(max);
		Node node = l.remove(l.size() - 1);
		this.dll.remove(node);
		if (l.isEmpty()) {
			this.map.remove(max);
		}
		return max;
	}
}

class MaxStack2 {
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack2() {
		this.stack = new Stack<>();
		this.maxStack = new Stack<>();
	}

	public void push(int x) {
		int max = this.maxStack.isEmpty() ? x : this.maxStack.peek();
		this.maxStack.push(max > x ? max : x);
		this.stack.push(x);
	}

	public int pop() {
		this.maxStack.pop();
		return this.stack.pop();
	}

	public int top() {
		return this.stack.peek();
	}

	public int peekMax() {
		return this.maxStack.peek();
	}

	public int popMax() {
		int max = peekMax();
		Stack<Integer> buffer = new Stack<>();
		while (top() != max) {
			buffer.push(pop());
		}
		pop();
		while (!buffer.isEmpty()) {
			push(buffer.pop());
		}
		return max;
	}
}