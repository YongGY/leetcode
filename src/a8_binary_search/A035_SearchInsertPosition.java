package a8_binary_search;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * @author William
 *
 */
public class A035_SearchInsertPosition {



	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;


//		if(nums == null || nums.length == 0){
//			return 0;
//		}
//		int left = 0;
//		int right = nums.length - 1;
//		if(target <= nums[0]){
//			return 0;
//		}
//		if(target > nums[right]){
//			return right;
//		}
//		if(target == nums[right]){
//			return right - 1;
//		}
//
//		while(left <= right){
//			int mid = left + (right - left) / 2;
//			if(nums[mid] == target){
//				return  mid - 1;
//			}
//			if(nums[mid] > target){
//				right--;
//			}else if(nums[mid] < target){
//				left++;
//			}else{
//				if(nums[left] > target && nums[right] < target){
//
//				}
//			}
//		}
//
//		return 0;

	}
    
 	public static void main(String[] args) {
 		
	}
}
