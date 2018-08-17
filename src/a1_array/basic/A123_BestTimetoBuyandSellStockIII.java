package a1_array.basic;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * 
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * 
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author William
 *
 * 这道题是Best Time to Buy and Sell Stock的扩展，现在我们最多可以进行两次交易。
 * 
 * 我们仍然使用动态规划来完成，事实上可以解决非常通用的情况，也就是最多进行k次交易的情况。
 * 这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。我们还是使用“局部最优和全局最优解法”。
 * 我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
 * 
 * 下面我们来看递推式，全局的比较简单， global[i][j]=max(local[i][j],global[i-1][j])，
 * 也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。
 * 
 * 对于局部变量的维护，递推式是local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
 * 也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，
 * 如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），第二个量则是取local第i-1天j次交易，
 * 然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，
 * 而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
 * 
 * 上面的算法中对于天数需要一次扫描，而每次要对交易次数进行递推式求解，所以时间复杂度是O(n*k)，如果是最多进行两次交易，那么复杂度还是O(n)。
 * 空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)。
 */
public class A123_BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int[] local = new int[3];
		int[] global = new int[3];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = 2; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[2];
	}

	/**
	 * 滚动扫描法
	 * 复杂度
	 * 		时间 O(N) 空间 O(1)
	 *
	 * 思路
	 * 		其实我们并不需要知道每个时间点买卖第一第二笔股票收益的全部信息，我们只要知道前一个时间点买卖第一第二笔股票的最大收益信息，
	 * 		就可以直到当前最大的收益信息了，这样可以为我们省去额外空间。
	 *
	 * 		这里我们遍历prices数组的时候，维护四个变量:
	 *
	 *
	 * 		release2是在该价格点卖出第二笔股票后手里剩的钱，等于上一轮买入第二笔股票后手里剩的钱加上卖出当前股票价格的钱，
	 * 		或者上一轮卖出第二笔股票后手里剩的钱两者中较大的。
	 *
	 * 		hold2是在该价格点买入第二笔股票后手里剩的钱，等于上一轮卖出第一笔股票后手里剩的钱减去买入当前股票价格的钱，
	 * 		或者上一轮买入第二笔股票后手里剩的钱两者中较大的。
	 *
	 * 		release1是在该价格点卖出第一笔股票后手里剩的钱，等于上一轮买入第一笔股票后手里剩的钱加上卖出当前股票价格的钱，
	 * 		或者上一轮卖出第一笔股票后手里剩的钱两者中较大的。
	 *
	 * 		hold1是在该价格点买入第一笔股票后手里剩的钱，等于初始资金减去买入当前股票价格的钱或者初始资金（不买）中较大的。
	 *
	 * 		这里计算顺序按照release2 -> hold2 -> release1 -> hold1，
	 * 		因为卖是要后于买的，而第二次交易也是后于第一次交易的，通过这个顺序我们能用这些变量自身来记录上次的值。
	 * 		相当于release2的时间点要先于hold1四个点。
	 *
	 * 	Prices      3    1    2    8    3    1    9    6
	 *  release2    0    0    1    7    7    7    1    1
	 *  hold2      -3   -1   -1   -1    4    6    1    1
	 *  release1    0    0    1    7    7    7    1    1
	 *  hold1      -3   -1   -1   -1   -1   -1    3    3
	 */

	public int maxProfit1(int[] prices) {
		int hold1 = Integer.MIN_VALUE;
		int hold2 = Integer.MIN_VALUE;
		int release1 = 0;
		int release2 = 0;

		for (int i = 0; i < prices.length; i++) {
			//在该价格点卖出第二笔股票后手里剩的钱，等于上一轮买入第二笔股票后手里剩的钱加上卖出当前股票价格的钱，或者上一轮卖出第二笔股票后手里剩的钱两者中较大的
			release2 = Math.max(release2, hold2 + prices[i]);
			//在该价格点买入第二笔股票后手里剩的钱，等于上一轮卖出第一笔股票后手里剩的钱减去买入当前股票价格的钱，或者上一轮买入第二笔股票后手里剩的钱两者中较大的
			hold2 = Math.max(hold2, release1 - prices[i]);
			//在该价格点卖出第一笔股票后手里剩的钱，等于上一轮买入第一笔股票后手里剩的钱加上卖出当前股票价格的钱，或者上一轮卖出第一笔股票后手里剩的钱两者中较大的
			release1 = Math.max(release1, hold1 + prices[i]);
			//在该价格点买入第一笔股票后手里剩的钱，等于初始资金减去买入当前股票价格的钱或者初始资金（不买）中较大的
			hold1 = Math.max(hold1, -prices[i]);
		}
		return release2;
	}
}
