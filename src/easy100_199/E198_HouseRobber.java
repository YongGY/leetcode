package easy100_199;

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
 */

public class E198_HouseRobber {

	public static  int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0 ;
		}
		int [] money = new int[2];
		money[0] = 0;
		money[1] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = money[0];
			money[0] = Math.max(money[0], money[1]);
			money[1] = temp + nums[i];
			System.out.println(money[0] + "  =   " + money[1]);
		}
		
		return money[0] > money[1] ? money[0] : money[1];
	}
	
	public static void main(String[] args) {
		System.out.println(rob(new int[] {8,3,6,15,4,9,7,10}));
	}
}
