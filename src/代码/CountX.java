package fb;

/**
 * sorted array [1, 2, 2, 2, 4, 5, 9], 
 * x = 2 return 3 
 * x = 9 return 1
 * x = 10 return 0
 */
public class CountX {

	public static int countX(int[] arr, int x) {
		int n = arr.length;
		int left = findFirst(arr, 0, n - 1, x);
		if (left == -1) {
			return 0;
		}

		int right = findLast(arr, left, n - 1, x);
		return right - left + 1;
	}

	private static int findFirst(int[] nums, int start, int end, int target) {
		// find first occurrence of target in range [left, right], return index
		int result = -1;
		while (start <= end && nums[start] <= target && target <= nums[end]) {
			if (nums[start] == target) {
				return start;
			}
			int mid =  (end + start) /2 ;
			if (nums[mid] == target) {
				end = mid - 1;
				result = mid;
			} else if (nums[mid] > target)
				end = mid - 1;
			else {
				start = mid + 1;
			}
		}
		return result;
	}

	private static int findLast(int[] nums, int start, int end, int target) {
		// find last occurrence of target in range [left, right], return index
		int result = -1;
		while (start <= end && nums[start] <= target && target <= nums[end]) {
			if (nums[end] == target) {
				return end;
			}
			int mid =  (end + start) /2 ;
			if (nums[mid] == target) {
				start = mid + 1;
				result = mid;
			} else if (nums[mid] > target)
				end = mid - 1;
			else {
				start = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 2, 2, 4, 5, 9 };
		System.out.println(countX(arr, 2));
		System.out.println(countX(arr, 9));
		System.out.println(countX(arr, 10));
	}
}
