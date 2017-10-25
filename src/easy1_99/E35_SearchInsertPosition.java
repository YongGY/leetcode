package easy1_99;

import javax.sound.midi.MidiChannel;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 → 2 
 * [1,3,5,6], 2 → 1 
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author yongguo
 *
 */
public class E35_SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int low = 0;
		int hight = nums.length - 1;
		
		while (low <= hight) {
			int mid = (low + hight) / 2;

			if (nums[mid] > target) {
				hight = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 0));
 	}

}
