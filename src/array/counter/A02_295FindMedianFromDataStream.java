package array.counter;

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
 * 
 * Two-heap solution
 * Obviously we are doing redundant works here. We only want the median but we are sorting the whole array. That includes unnecessary work.
 * 
 * In order to prevent from doing useless work, we have to use some data structure to give us the medians without sorting the whole array. 
 * Considering that medians is mainly determined by the middle 2 numbers in the input stream, what we need to know is the MAXMIUM of the smaller half and the MINIMUM of the larger half. 
 * Thus we could store the whole input stream into 2 heaps in which each contains half of the stream. 
 * And left half should be stored in a max-heap, which allows us to get the maximum of the smaller half, 
 * right half should be stored in a min-heap, which allows us to get the minimum of the greater half. 
 * And combines the 2 will give us the median given the size of the input stream (odd or even).
 * 
 * In this way, the time of get the median will be O(1) for get, O(logn) for insert. 
 * Space is still O(n). Specifically the time for insertion is O(5 * logn) in the worst case, 
 * the condition is: when the 2 heap is of the same size before we insert a number, then it takes O(2 * logn) to insert the number, 
 * take out the max and repercolate the the max. After that, it takes another O(3 * logn) to insert the number to right, take the min from right, 
 * repercolate min of right and insert the min to left.
 * 
 * Also keep in mind that when the total number of data is odd, we keep the smaller half heap to hold 1 more element than the greater half.
 * 
 */
 
  class MedianFinder {
	PriorityQueue<Integer> minHeap; // larger part
	PriorityQueue<Integer> maxHeap; // smaller part

	/** initialize your data structure here. */
	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
	}

	public void addNum(int num) {
		minHeap.offer(num);
		maxHeap.offer(minHeap.poll());
		if (minHeap.size() < maxHeap.size())
			minHeap.offer(maxHeap.poll());
	}

	public double findMedian() {
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
	}

}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
