package array.basic;

/**
 * Say you have an array for which the i(th) element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author William
 *
 *
 *  min_price is the minimum price so far. The maximum profit must happen when current price - min_price is max.
 *  The maximum profit equals the max(sell) – min(buy) 
 *  so we can keep the min sell price and update the max(price[i] – min)
 *
 */
public class A121_BestTimetoBuyandSellStock {
 
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int min = prices[0]; // // min代表目前股票出現的最低價
		int profit = 0;  // 目前獲利
		for (int i = 1; i < prices.length; i++) {

			// ( prices[i] - min )計算現在的價錢可以獲利多少
			// 并计算 現在的價錢賣出是否可以獲得更高的獲利
			profit = Math.max(profit, prices[i] - min);

			// 找出最低點買進
			min = Math.min(min, prices[i]);
		}
		return profit;

	}

	//先买入才能卖出、卖价一定要比买入价格高才能成交就可以了。
	public int maxProfit1(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}

		int maxProfit = 0;
		int minBuyPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			int curPrice = prices[i];
			if (curPrice < minBuyPrice) {
				minBuyPrice = curPrice;
			} else if (curPrice - minBuyPrice > maxProfit) {
				maxProfit = curPrice - minBuyPrice;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
	
}
