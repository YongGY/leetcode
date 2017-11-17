package medium1_99;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 题意：
 * 有一排竖直放置的、长短不一的圆柱，圆柱之间间隔都是1，问哪2根圆柱（用ai，aj表示)可以组成一个体积（因为是二维空间，其实就是面积）最大的水容器。
 * 注意：容器里面放着其他圆柱也是没影响的，ai和aj不要求相邻；因为是水容器，所以最短边决定了容器的容量。
 * 
 * 题解： 
 * 这道题并不是动态规划题， 原因是动态规划的一个条件——无后效性，无法满足。
 * 无后效性是这样一种性质：某阶段的状态一旦确定，则此后过程的演变不再受此前各种状态及决策的影响，简单的说，就是“未来与过去无关”，当前的状态是此前历史的一个完整总结。
 * 
 * @author William
 *
 */
public class M11_ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int lo = 0;
		int hi = height.length - 1;
		int max = 0;
		while(lo < hi) {
			int min = Math.min(height[lo], height[hi]); //找短最小的边，最短边决定了容器的容量
 			max = Math.max(max, min * (hi - lo)); //(hi - lo) 通过两下标相减行到“长”-两边之间距离
			while(lo <= hi && height[lo] <= min) lo++; //当左边下标小于右边下标 &&　当前左边指针对应的值 比最小的还小 就向右移
			while(lo <= hi && height[hi] <= min) hi--; //当左边下标小于右边下标 &&　当前右边指针对应的值 比最小的还小 就向左移
		}
		return max;

	}

	public static void main(String[] args) {
		 System.out.println(maxArea(new int[] {1,4,3,2,4}));

	}

}
