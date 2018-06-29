package array.basic;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * 
 * Note:
 * 
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 * 
 * Input: 
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 
 * Output: 3
 * 
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * 
 * Input: 
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 
 * Output: -1
 * 
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * 
 * 
 * 非常经典的一道题。可以转换成求最大连续和做，但是有更简单的方法。基于一个数学定理：
 * 
 * 如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
 * 
 * 有了这个定理，判断到底是否存在这样的解非常容易，只需要把全部的油耗情况计算出来看看是否大于等于0即可。
 * 
 * 那么如何求开始位置在哪？
 * 
 * 注意到这样一个现象：
 * 
 * 1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。 
 * 
 * 2.现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程(废话)。
 * 那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？
 * 因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。
 * 同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
 * 
 * 
 * 解题思路：
 * 初始时，油箱中的油量为0，我们记tank = 0。
 * 
 * 从第一个油站出发：此时，油量为 tank += gas[0] - cost[0]。如果tank > 0，说明我们可以到达下一个油站。
 * 
 * 到达油站 i 时：此时，油量为 tank += gas[i] - cost[i]。如果tank >= 0，可以到达下一个油站，继续往下走。
 * 可是，如果 tank < 0呢？这时，我们不可能到达下一个油站（i + 1）了。
 * 并且，假设我们是从 begin 出发的，不仅从 begin 到不了油站 i + 1，并且从 begin 到 i 之间的任何一个油站出发都不可能到达油站 i + 1。
 * 
 * 因此，我们需要把起点设置为油站 i + 1，油箱清空，重新开始往下走。
 * 最终，begin 总是会指向一个有可能走完一圈的开始地点。
 * 但是，从 begin 出发，究竟能否走完一圈呢？
 * 
 * 记录所有油站的总供油量：totalGas = gas[0] + gas[1] + ... + gas[n - 1]。
 * 以及总耗油量：totalCost = cost[0] + cost[1] + ... + cost[n - 1]。
 * 
 * 如果totalGas >= totalCost，那么肯定能走完一圈的。而且，begin 所在的位置就是那个起点（因为无效的起点已经在tank < 0时被排除掉了）。
 * 如果totalGas < totalCost，那肯定是走不完一圈了。
 *  
 * 
 * @author William
 *
 */
public class A08_134GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0;
		int totalCost = 0;
		int tank = 0;
		int begin = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			tank += (gas[i] - cost[i]);
			if (tank < 0) {
				begin = i + 1;
				tank = 0;
			}
		}
		return (totalGas >= totalCost ? begin : -1);
	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
	}
}
