package easy1_100;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * @author William
 *
 */
public class E53_MaximumSubarray {
	
    public static int maxSubArray(int[] nums) {
        int [] S = new int[nums.length];
        S[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < S.length; i++) {
			S[i] = Math.max(nums[i], (S[i-1]+nums[i]));
			max = Math.max(max,S[i]);
		}
		return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
