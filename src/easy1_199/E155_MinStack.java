package easy1_199;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack. 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2); 
 * minStack.push(0);
 * minStack.push(-3); 
 * minStack.getMin(); 	--> Returns -3. 
 * minStack.pop();
 * minStack.top(); 		--> Returns 0. 
 * minStack.getMin(); 	--> Returns -2.
 * 
 * @author William
 * 
 */
public class E155_MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
    public E155_MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty()) {
    		minStack.push(x);
    	}else if(x <= minStack.peek()) {
    		minStack.push(x);
    	}
    }
    
    public void pop() {
    	int p = stack.pop();
    	if(p == minStack.peek()) {
    		minStack.pop();
    	}
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	 return minStack.peek();
    }

	public static void main(String[] args) {
//		E155_MinStack obj = new E155_MinStack();
//		 obj.push(x);
//		 obj.pop();
//		 int param_3 = obj.top();
//		 int param_4 = obj.getMin();
	}
}
