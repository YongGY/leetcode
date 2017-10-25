package easy1_99;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author William
 *
 */
public class E70_ClimbingStairs {

	public static int climbStairs(int n) {
        int[] f = new int[]{0,1,2};
        if(n < 3) return f[n];
        for(int i = 2; i < n; i++){
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
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	public static int climbStairs2(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs2(7));
		System.out.println(climbStairs1(7));
		System.out.println(climbStairs(7));

	}

}
