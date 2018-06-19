package easy1_199;

/**
 * 
 * You are a professional robber planning to rob houses along a street.
 * 
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * 一般来说，给定一个规则，让我们求任意状态下的解，都是用动态规划。这里的规则是劫匪不能同时抢劫相邻的屋子，即我们在累加时，只有两种选择：
 * 
 * 如果选择了抢劫上一个屋子，那么就不能抢劫当前的屋子，所以最大收益就是抢劫上一个屋子的收益
 * 
 * 如果选择抢劫当前屋子，就不能抢劫上一个屋子，所以最大收益是到上一个屋子的上一个屋子为止的最大收益，加上当前屋子里有的钱
 * 
 * 所以，我们只要判断一下两个里面哪个大就行了，同时也是我们的递推式。
 * 
 * 另外我们可以做一点优化，本来我们是要用一个dp数组来保存之前的结果的。但实际上我们只需要上一次和上上次的结果，所以可以用两个变量就行了。
 * 
 * The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]).
 * 
 */

public class E198_HouseRobber {

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] money = new int[2];
		money[0] = 0;
		money[1] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = money[0];
			money[0] = Math.max(money[0], money[1]);
			money[1] = temp + nums[i];
		}

		return money[0] > money[1] ? money[0] : money[1];
	}

	public static int rob1(int[] nums) {
		if (nums.length <= 1) {
			return nums.length == 0 ? 0 : nums[0];
		}
		// a是上次的最大收益
		int a = nums[0];
		// b是当前的最大受益
		int b = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int tmp = b;
			// 当前的最大收益是两种选择里较大的那个
			b = Math.max(a + nums[i], b);
			a = tmp;
		}
		return b;
	}

	public static int rob2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		
		for (int i = 0; i < dp.length; i++) {
			System.out.print(","+dp[i]);
		}
		System.out.println();
			
 		return dp[nums.length - 1];
	}
	
	
	public static void main(String[] args) {
//		System.out.println(rob(new int[] { 8, 3, 6, 15, 4, 9, 7, 10 }));
//		System.out.println(rob1(new int[] { 8, 3, 6, 15, 4, 9, 7, 10 }));
		System.out.println(rob2(new int[] { 8, 3, 6, 15, 4, 9, 7, 10 }));
	}
}
