package test;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();

	// 方法：入栈操作
	public void push(int data) {
		queue1.add(data);
	}

	// 方法：出栈操作
	public int pop() throws Exception {
		int data;
		if (queue1.size() == 0) {
			throw new Exception("栈为空");
		}

		while (queue1.size() != 0) {
			if (queue1.size() == 1) {
				data = queue1.poll();
				while (queue2.size() != 0) { // 把queue2中的全部数据放到队列一中
					queue1.add(queue2.poll());
					return data;
				}
			}
			queue2.add(queue1.poll());
		}
		throw new Exception("栈为空");// 不知道这一行的代码是什么意思
	}

	public static void main(String[] args) throws Exception {
		StackUsingQueues stack = new StackUsingQueues();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(4);
	}
}