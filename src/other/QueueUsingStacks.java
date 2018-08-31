package other;

import java.util.Stack;

public class QueueUsingStacks {

	private Stack<Integer> stack1 = new Stack<>();// 执行入队操作的栈
	private Stack<Integer> stack2 = new Stack<>();// 执行出队操作的栈

	// 方法：给队列增加一个入队的操作
	public void push(int data) {
		stack1.push(data);
	}

	// 方法：给队列正价一个出队的操作
	public int pop() throws Exception {
		if (stack2.empty()) {// stack1中的数据放到stack2之前，先要保证stack2里面是空的（要么一开始就是空的，要么是stack2中的数据出完了），不然出队的顺序会乱的，这一点很容易忘
			while (!stack1.empty()) {
				stack2.push(stack1.pop());// 把stack1中的数据出栈，放到stack2中【核心代码】
			}
		}
		if (stack2.empty()) { // stack2为空时，有两种可能：1、一开始，两个栈的数据都是空的；2、stack2中的数据出完了
			throw new Exception("队列为空");
		}
		return stack2.pop();
	}

	public static void main(String[] args) throws Exception {
		QueueUsingStacks queue = new QueueUsingStacks();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		System.out.println(queue.pop());

		queue.push(4);

		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());

	}

}