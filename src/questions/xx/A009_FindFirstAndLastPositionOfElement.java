package questions.xx;

public class A009_FindFirstAndLastPositionOfElement {

	/**
	 * 34. Find First and Last Position of Element in Sorted Array
	 * 
	 * Given an array of integers nums sorted in ascending order, find the
	 * starting and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
	 * 
	 */
	public static int[] findFirstAndLast(int[] nums, int target) {
		int[] res = { -1, -1 };

		if (nums.length == 0 || nums == null)
			return res;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (res[0] == -1) {
					res[0] = i;
				}
				res[1] = i;
			}
		}
		return res;
	}
	
    public static void findFirstAndLast1(int arr[], int x)
    {
        int n = arr.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++)
        {
            if (x != arr[i])
                continue;
            if (first == -1)
                first = i;
            last = i;
        }
        if (first != -1){
            System.out.println( "First Occurrence = "  + first);
            System.out.println("Last Occurrence = " + last);
        }
        else
            System.out.println("Not Found");
    }

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int x = 8;
		findFirstAndLast(arr, x);
	}

}