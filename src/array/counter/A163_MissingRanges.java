package array.counter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, 
 * where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * 
 * Example:
 * 
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * 
 * @author William
 *
 */
public class A163_MissingRanges {

	private static String range(int lower, int upper) {
		if (lower == upper){
			return lower+"";
		}
		return lower + "->" + upper;
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			list.add(range(lower, upper));
			return list;
		}
		
		if (lower < nums[0]){
			list.add(range(lower, nums[0] - 1));
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] + 1 < nums[i + 1]){
				list.add(range(nums[i] + 1, nums[i + 1] - 1));
			}
		}
		
		if (nums[nums.length - 1] < upper){
			list.add(range(nums[nums.length - 1] + 1, upper));
		}
		return list;
	}
     
    public static void main(String[] args) {
		System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75},0,99));
		System.out.println(findMissingRanges(new int[]{2, 5, 10, 50, 75},0,99));
	}
}


