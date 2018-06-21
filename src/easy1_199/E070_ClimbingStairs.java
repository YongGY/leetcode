package easy1_199;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 
 * Output: 2 
 * Explanation: There are two ways to climb to the top. 
 * 
 * 1. 1 step + 1 step 
 * 2. 2 steps 
 * 
 * Example 2:
 * 
 * Input: 3 
 * Output: 3 
 * Explanation: There are three ways to climb to the top. 
 * 1. 1 step + 1 step + 1 step 
 * 2. 1 step + 2 steps 
 * 3. 2 steps + 1 step
 * 
 * 
 * 这道题就是经典的讲解最简单的DP问题的问题。。
 * 
 * 假设梯子有n层，那么如何爬到第n层呢，因为每次只能爬1或2步，
 * 
 * 那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
 * 
 * 所以递推公式非常容易的就得出了： dp[n] = dp[n-1] + dp[n-2]
 * 
 * 如果梯子有1层或者2层，dp[1] = 1, dp[2] = 2，如果梯子有0层，自然dp[0] = 0
 * 
 * @author William
 *
 */
public class E070_ClimbingStairs {

	public static int climbStairs(int n) {
		int[] f = new int[] { 0, 1, 2 };
		if (n < 3)
			return f[n];
		for (int i = 2; i < n; i++) {
			f[0] = f[1];
			f[1] = f[2];
			f[2] = f[0] + f[1];
		}
		return f[2];
	}

	public static int climbStairs1(int n) {
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int climbStairs2(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs2(7));
		System.out.println(climbStairs1(7));
		System.out.println(climbStairs(5));

	}

}
