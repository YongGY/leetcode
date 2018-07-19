package difficulty.easy200_399;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. 
 * pop() -- Removes the element
 * from in front of queue. 
 * peek() -- Get the front element. 
 * empty() -- Returnwhether the queue is empty. 
 * 
 * Notes: You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty
 * operations are valid. 
 * 
 * Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-endedqueue), as long as you use only standard operations of a stack. 
 * 
 * You may assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 */

public class E232_ImplementQueueUsingStacks {
	
	
	class MyQueue {
		
	    Stack<Integer> s1 = new Stack<Integer>();
	    Stack<Integer> s2 = new Stack<Integer>();

	    /** Initialize your data structure here. */
	    public MyQueue() {

	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        while(!s1.isEmpty()){  
	            s2.push(s1.pop());  
	        }  
	        s2.push(x);  
	        while(!s2.isEmpty()){  
	            s1.push(s2.pop());  
	        }  
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	return s1.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	return s1.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return s1.isEmpty();
	    }
	}
}