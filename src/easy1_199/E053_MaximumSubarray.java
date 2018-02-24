package easy1_199;

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
 *
 * 思路
 * 这是一道非常典型的动态规划题，为了求整个字符串最大的子序列和，我们将先求较小的字符串的最大子序列和。
 * 这里我们从后向前、从前向后计算都是可以的。
 * 在从前向后计算的方法中，我们将第i个元素之前最大的子序列和存入一个一维数组dp中，
 * 对第i+1个元素来说，它的值取决于dp[i]，如果dp[i]是负数，那就没有必要加上它，因为这只会拖累子序列的最大和。
 * 如果是正数就加上它。最后我们再讲第i+1个元素自身加进去，就得到了第i+1个元素之前最大的子序列和。
 *
 */
public class E053_MaximumSubarray {
	
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = sum < 0 ? nums[i] : sum + nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
	
	
    public static int maxSubArray01(int[] nums) {
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
