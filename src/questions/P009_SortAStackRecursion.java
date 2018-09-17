package questions;

import java.util.Stack;

public class P009_SortAStackRecursion {

	// Recursive Method to insert an item x in sorted way
	static void sortedInsert(Stack<Integer> s, int x) {
		// Base case: Either stack is empty or newly inserted
		// item is greater than top (more than all existing)
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}

		// If top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	// Method to sort stack
	static void sortStack(Stack<Integer> s) {
		// If stack is not empty
		if (!s.isEmpty()) {
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}

	// Driver method
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);

		sortStack(s);

		while (!s.empty()) {
			System.out.print(s.pop() + " ");
		}

	}
}
