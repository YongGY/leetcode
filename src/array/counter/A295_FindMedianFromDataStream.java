package array.counter;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * 
 * For example,
 * [2,3,4], the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * Example:
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * @author William
 *
 *
 * 寻找datastream或者array中的中位数， 可以用两个heap来实现，一个max heap，一个min heap。
 * 每次加一个数先放到max heap，然后把max heap中poll一个数出来放到min heap。 
 * 同时要检查下max heap中的元素比min heap中要多；
 * 取中位数的时候，如果两个heap的size相同，则各poll一个元素出来算平均，否则max heap中poll出的就是median.
 *
 */
 
 public class A295_FindMedianFromDataStream {


	class MedianFinder {

		// max queue is always larger or equal to min queue
		PriorityQueue<Integer> minHeap;
		PriorityQueue<Integer> maxHeap;

		public MedianFinder() {
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
			if (maxHeap.size() < minHeap.size()){
				maxHeap.offer(minHeap.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (maxHeap.size() == minHeap.size()) {
				return (maxHeap.peek() + minHeap.peek()) /  2.0;
			}
			else{
				return maxHeap.peek();
			}
		}
	}

	public static void main(String[] args) {
		MedianFinder m = new A295_FindMedianFromDataStream().new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		m.addNum(3);
		m.addNum(4);
		System.out.println(m.findMedian());
	}
}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
