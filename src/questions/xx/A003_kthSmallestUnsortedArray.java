package questions.xx;

import java.util.Arrays;
import java.util.PriorityQueue;


public class A003_kthSmallestUnsortedArray {

	/**
	 * The kth smallest in a unsorted array
	 * Time is O(nlog(n)).
	 */

	public static int kthSmallest(Integer[] arr, int k) {
		// Sort the given array
		Arrays.sort(arr);

		// Return k'th element in
		// the sorted array
		return arr[k - 1];
	}

	/**
	 * Java Solution 2 - Quick Sort
	 * 
	 * This problem can also be solved by using quickselect, which is similar to quicksort.
	 * 
	 * Average case time is O(n), worst case time is O(n^2).
	 * 
	 */
	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	
	
	
	/**
	 * Java Solution 3 - Heap
	 * 
	 * We can use a min heap to solve this problem. The heap stores the top k
	 * elements. Whenever the size is greater than k, delete the min.
	 * 
	 * Time complexity is O(nlog(k)).
	 * 
	 * Space complexity is O(k) for storing the top k numbers.
	 * 
	 */

	public int findKthLargestByHeap(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	    return q.peek();
	}

	
	
	// driver program
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
		int k = 2;
		System.out.print("K'th smallest element is " + kthSmallest(arr, k));
	}
	
}
