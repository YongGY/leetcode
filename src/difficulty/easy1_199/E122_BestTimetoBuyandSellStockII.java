package difficulty.easy1_199;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author William
 * 
 * 
 * 这道题跟Best Time to Buy and Sell Stock类似，求最大利润。
 * 区别是这里可以交易无限多次（当然我们知道交易不会超过n-1次，也就是每天都进行先卖然后买）。
 * 既然交易次数没有限定，可以看出我们只要对于每次两天差价大于0的都进行交易，就可以得到最大利润。
 * 因此算法其实就是累加所有大于0的差价既可以了，非常简单。
 * 如此只需要一次扫描就可以了，时间复杂度是O(n)，空间上只需要O(1)存一个累加结果即可
 * 
 */
public class E122_BestTimetoBuyandSellStockII {

	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i+1] - prices[i];
			if(diff > 0) {
				res += diff;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit((new int[] {7, 1, 5, 3, 6, 4})));

	}

}
