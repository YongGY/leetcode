package array.basic;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * 
 * Example 2:
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *              The third child gets 1 candy because it satisfies the above two conditions.
 * 
 * @author William
 *
 * 模拟这个过程，可能会想到： 
 * 求最少需要多少糖果，先每个人分配一个，再根据等级依次加一个糖果。
 * 
 * 但上述思路是会有问题的，那就是对于小孩i来说，假设他的等级既高于小孩i−1又高于小孩i+1，那么他得到的糖果就要比小孩i−1和小孩i+1的糖果中的较多者要多一个，
 * 
 * 这样看的话一次循环可能搞不定，因为第一次循环中在计算第i个小孩的糖果时，第i+1个小孩的数据还没出来呢。
 * 
 * 因此两次循环，一次从左到右，一次从右往左。
 * 
 * 方法一：
 * 1、假设每个孩子分到的糖果数组为A[N]，初始化为{1}，因为每个人至少分到一颗糖。
 * 
 * 2、与前面的邻居比较，前向遍历权重数组ratings，如果ratings[i]>ratings[i-1]，则A[i]=A[i-1]+1；
 * 
 * 3、与后面的邻居比较，后向遍历权重数组ratings，如果ratings[i]>ratings[i+1]且A[i]<A[i+1]+1，则更新A，A[i]=A[i+1]+1；
 * 
 * 4、对A求和即为最少需要的糖果。
 *
 */
public class A34_135Candy {
	public static int candy(int[] ratings) {
		int length = ratings.length;
		if (length <= 0)
			return 0;
		int[] nums = new int[length];
		nums[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			nums[i] = 1;
			if (ratings[i] > ratings[i - 1])
				nums[i] = nums[i - 1] + 1;
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				nums[i] = Math.max(nums[i], nums[i + 1] + 1);
		}

		int count = 0;
		for (int i = 0; i < length; i++)
			count += nums[i];
		return count;
	}
	public static void main(String[] args) {
		System.out.println(candy(new int[] {1,0,2}));
		System.out.println(candy(new int[] {1,2,2}));
	}
}
