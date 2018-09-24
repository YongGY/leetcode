package test;

public class X001_FindMaxSubarraySum {

	
	/**
	 * Given a unsorted integer array,  find the largest sum in continuous subarray. 
	 * E.g. [1,2,-4,3,4,-1,4,5,-10], the result is sum([3,4,-1,4,5]) = 15. 
	 * And how to design it in a web service.
	 * @param args
	 */
	
	
	public static int findMaxSubarraySum(int[] nums){
		
		int max = nums[0];
		int sum = nums[0];
		for(int i = 1; i < nums.length; i++){
			sum = (sum + nums[i] > nums[i] ? sum + nums[i] : nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxSubarraySum(new int[]{1,2,-4,3,4,-1,4,5,-10}));
	}

}
