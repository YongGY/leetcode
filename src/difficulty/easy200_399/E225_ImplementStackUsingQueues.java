package difficulty.easy200_399;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty.
 * 
 * Notes: You must use only standard operations of a queue -- which means only
 * push to back, peek/pop from front, size, and is empty operations are valid.
 * 
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * 
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 */

//https://segmentfault.com/a/1190000012685111
// E219_ImplementTackUsingQueues
public class E225_ImplementStackUsingQueues {

	class MyStack {

		private Queue<Integer> q1 = new LinkedList<>();
		private Queue<Integer> q2 = new LinkedList<>();

		/** Initialize your data structure here. */
		 public MyStack() {
		
		 }

		/** Push element x onto stack. */
		public void push(int x) {
			q2.offer(x);
			while (!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			return q1.poll();
		}

		/** Get the top element. */
		public int top() {
			return q1.peek();
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return q1.isEmpty();
		}

	}

	public static void main(String[] args) {
		// MyStack obj = new MyStack();
		// obj.push(1);
		// obj.push(2);
		// obj.push(3);
		// int param_2 = obj.pop();
		// int param_3 = obj.top();
		// boolean param_4 = obj.empty();
	}

	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */

}
