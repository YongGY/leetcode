package easy1_199;

/**
 * Say you have an array for which the i(th) element is the price of a given
 * stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5 max. difference = 6-1 = 5 (not
 * 7-1 = 6, as selling price needs to be larger than buying price)
 * 
 * Example 2: Input: [7, 6, 4, 3, 1] Output: 0 In this case, no transaction is
 * done, i.e. max profit = 0.
 * 
 * @author William
 * 
 * 
 * 
 *         题意： 用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
 *         如果只允许进行一次交易，也就是说只允许买一支股票并卖掉，求最大的收益。
 * 
 *         分析：
 *         动态规划法。从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，并计算以当天价格出售的收益，作为可能的最大收益，整个遍历过程中，出现过的最大收益就是所求
 *         代码：时间O(n)，空间O(1)。
 * 
 * 
 */
public class E121_BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int min = prices[0]; // min so far
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return profit;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
	
}
