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

	//peekFirst() 方法检索此deque队列的第一个元素(但不删除)，则返回null如果此deque队列为空。
	//peekLast() 方法检索此deque队列的最后一个元素(但不删除)。返回null如果此deque队列为空。
	//poll() 检索并移除此queue队列表示的队列的头部。返回null如果此queue队列为空。
	//removeLast()方法检索并移除此deque队列的最后一个元素。


	/**
	 * https://segmentfault.com/a/1190000003903509
	 *
	 * 双向队列
	 *
	 * 复杂度
	 * 时间 O(N) 空间 O(K)
	 *
	 * 注意
	 * -结果数组的大小是nums.length + 1 - k， 赋值时下标也是i + 1 - k
	 *
	 * 思路
	 * 我们用双向队列可以在O(N)时间内解决这题。
	 * 当我们遇到新的数时，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾扔掉，直到该队列的末尾比新数大或者队列为空的时候才住手。
	 * 这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，所以他们其实就是窗口内第一大，第二大，第三大...的数。
	 * 保持队列里只有窗口内数的方法是每来一个新的把窗口最左边的扔掉，然后把新的加进去。
	 * 然而由于我们在加新数的时候，已经把很多没用的数给扔了，这样队列头部的数并不一定是窗口最左边的数。
	 * 这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以知道这个数的值，也可以知道该数是不是窗口最左边的数。
	 * 这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，一次是加入队列的时候，一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。
	 */


	/**
	 * 		给出数组 [1,2,7,7,8], 滑动窗口大小为 k = 3. 返回 [7,7,8].
	 * 		最开始，窗口的状态如下：
	 * 		[1, 2 ,7 ,7 , 8], 最大值为 7;
	 * 		然后窗口向右移动一位：
	 * 		[1, 2, 7, 7, 8], 最大值为 7;
	 * 		最后窗口再向右移动一位：
	 * 		[1, 2, 7, 7, 8], 最大值为 8.
	 *
	 *
	 * 		已知 [1， 2， 7， 3， 8， 5， 3， 2]
	 * 		[1], 2进入, 2 > 1 弹出1
	 * 		[2], 7进入， 7 > 2 弹出2
	 * 		[7], 第一个窗口最大值为7，3进入，3 < 7
	 * 		[7, 3], 第二个窗口最大值为7，8进入， 8 > 3 弹出3
	 * 		[7], 8 > 7, 弹出7
	 * 		[8], 第三个窗口最大值为8
	 *
	 * 		当前为[9, 8, 7], 6进入，6 < 7, 6进入
	 * 		[9, 8, 7, 6] 但是对K=3的窗口，必须要弹出9，这步就要用到deque
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		LinkedList<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length + 1 - k];

		for (int i = 0; i < nums.length; i++) {
			// 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
			// window 是往右滑动的，每当往右滑动一个数，最左边的数要拿出来，我们要检查queue中的头部的下标是否等于i-k.
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.poll();
			}
			// 把队列尾部所有比新数小的都扔掉，保证队列是降序的
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}
			// 加入新数
			deque.offerLast(i);

			// 队列头部就是该窗口内第一大的
			// 检查如果是比较了至少k次，那就把i-l+1这个点的坐标对应结果放到最终结果里面。
			if ((i + 1) >= k) {
				res[i + 1 - k] = nums[deque.peek()];
			}
		}
		return res;
	}


	public int[] maxSlidingWindow1(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k) {
			return new int[]{};
		}
		int len = nums.length;
		// use p to record the index of the max num in last window
		// 使用p记录上一个窗口中最大数字的索引
		int p = -1;
		int[] res = new int[len - k + 1];
		for (int i = 0; i < len - k + 1; i++) {
			// p is in the current window, only need to compare nums[p] and the new item.
			// p在当前窗口中，只需要比较nums[p]和新项。
			if (p >= i) {
				if (nums[p] <= nums[i + k - 1]) {
					p = i + k - 1;
				}
			} else {
				// p is not in the current window, so iterate the current window and record the index of the max num to p
				p = i;
				for (int j = i + 1; j < i + k; j++) {
					if (nums[j] >= nums[p])
						p = j;
				}
			}
			res[i] = nums[p];
		}
		return res;
	}


	public static void main(String[] args) {
//		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3) ) );
//		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {4,2,5,3,7,9}, 3) ) );
//		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {1,2,7,7,8}, 3) ) );
//		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {9, 8, 7, 6}, 3) ) );
		System.out.println(Arrays.toString(   maxSlidingWindow(new int[] {1, 2, 7, 3, 8, 5, 3, 2}, 3) ) );
	}
}
