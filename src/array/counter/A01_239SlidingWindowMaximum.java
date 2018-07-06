package array.counter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
 * Return the max sliding window.
 * 
 * Example:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 *       Window position                Max
 *      ---------------               -----
 *      [1  3  -1] -3  5  3  6  7       3
 *       1 [3  -1  -3] 5  3  6  7       3
 *       1  3 [-1  -3  5] 3  6  7       5
 *       1  3  -1 [-3  5  3] 6  7       5
 *       1  3  -1  -3 [5  3  6] 7       6
 *       1  3  -1  -3  5 [3  6  7]      7
 *       
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 * @author William
 *
 */
public class A01_239SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k)
				deque.poll();

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}

			deque.offer(i);

			if (i + 1 >= k)
				result[i + 1 - k] = nums[deque.peek()];
 		}

		return result;
	}
	//peekFirst() 方法检索此deque队列的第一个元素(但不删除)，则返回null如果此deque队列为空。
	//peekLast() 方法检索此deque队列的最后一个元素(但不删除)。返回null如果此deque队列为空。
	//poll() 检索并移除此queue队列表示的队列的头部。返回null如果此queue队列为空。
	//removeLast()方法检索并移除此deque队列的最后一个元素。
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3) ) );
		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {4,2,5,3,7,9}, 3) ) );
	}
}
