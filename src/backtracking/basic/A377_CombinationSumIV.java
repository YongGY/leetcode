package backtracking.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * @author William
 *
 */
public class A377_CombinationSumIV {

	/**
	 * 思路1：DP - Fill each dp[i] from 0 to target indicating the possibilites to sum to i;
	 *           To fill each dp[i], we check through nums and pick any of element possible, at which it has target dp[target-nums[i]] possibility
	 *
	 *  eg:
	 * nums[1,2,3] target = 4
	 *
	 * dp[0, 1, 2, 3, 4] return dp[4]
	 *    1, 1, 2, 4, 7
	 *
	 * dp[4] = dp[4-1] + dp[4-2] + dp[4-3] = dp[3] + comb[2] + comb[1].
	 *
	 * 7 is from  1(dp of nums[0] = dp[1]) + 2(dp of nums[1]) + 4(dp of nums[2])
	 *
	 * To get 4, when at dp[4], we can choose any num[i] in nums and so it will have target-nums[i] possibility
	 */

	/**
	 * 我们需要一个一维数组dp，其中dp[i]表示目标数为i的解的个数，然后我们从1遍历到target
	 *
	 * 对于每一个数i，遍历nums数组如果i>=x,dp[i] += dp[i - x]。
	 *
	 * 这个也很好理解，比如说对于[1,2,3] 4，
	 * 这个例子，当我们在计算dp[3]的时候，3可以拆分为1+x，而x即为dp[2]，3也可以拆分为2+x，此时x为dp[1]，3同样可以拆为3+x
	 * 此时x为dp[0]，我们把所有的情况加起来就是组成3的所有情况了
	 */

	/**
	 * 解题思路：
	 *   因此根据这道题的解法提示选择使用DP的方法，
	 *   这时我们需要一个一维数组dp大小为target+1，从对应dp[i]存储的是目标i时所得的组合数，
	 *   然后我们从dp[1]开始计算直到dp[target]，每次计算dp[i]时的方法是，从头开始遍历nums数组，如果i>=nums[j]， dp[i] = dp[i] + dp[i-nums[j]]，
	 *   （比如题目中的例子[1，2，3]
	 *
	 *   计算dp[1] ：
	 *   从头开始遍历nums
	 *   当j = 0 时 因为1 >= nums[0] 故 dp[1] = dp[1] + dp[1- nums[0]],即 dp[1] = dp[1] + dp[0] = 1;
	 *   当j = 1 时 因为1 < nums[1]  故 不再运算 故dp[1] = 1;
	 *
	 *   计算 dp[2]:
	 *   当j = 0 时 因为2 >= nums[0] 故 dp[2] = dp[2] + dp[2- nums[0]],即 dp[2] = dp[2] + dp[1] = 1;
	 *   当j = 1 时 因为2 >= nums[1] 故 dp[2] = dp[2] + dp[2- nums[1]],即 dp[2] = dp[2] + dp[0] = 2;
	 *   当j = 2 时 因为2 < nums[2]  故 不再运算 故dp[2] = 2;
	 *
	 *   计算 dp[3]:
	 *   当j = 0 时 因为3 >= nums[0] 故 dp[3] = dp[3] + dp[3- nums[0]],即 dp[3] = dp[3] + dp[2] = 2;
	 *   当j = 1 时 因为3 >= nums[1] 故 dp[3] = dp[3] + dp[3- nums[1]],即 dp[3] = dp[3] + dp[1] = 3;
	 *   当j = 2 时 因为3 >= nums[2] 故 dp[3] = dp[3] + dp[3- nums[2]],即 dp[3] = dp[3] + dp[0] = 4;
 	 *   ….
	 *   …..
	 *   ….）
	 */
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i >= nums[j]) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}

 	public static void main(String[] args) {
 		
	}
}
