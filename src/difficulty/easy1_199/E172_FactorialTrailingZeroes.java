package difficulty.easy1_199;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 给定一个整数n，求阶乘结果的尾部0的个数。 也就是要找乘数中10的个数，而10可分解为2和5，
 * 而我们可知2的数量又远大于5的数量，那么此题即便为找出5的个数。 仍需注意的一点就是，像25,125，这样的不只含有一个5的数字需要考虑进去。
 * 
 * 
 * 分解因子, 当且仅当 因子中出现 一对 (2,5)时, 最后结果会增加一个 trailing zero.
 * 1. 2的个数永远多于5的个数.
 * 2. 计算5的个数时, 最简单的方法是 SUM(N/5^1, N/5^2, N/5^3...)
 * 
 */

public class E172_FactorialTrailingZeroes {

	public static int trailingZeroes(int n) {
		int res = 0;
		while (n > 0) {
			res += n / 5;
			n = n / 5;
		}
		return res;

		// return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static void main(String[] args) {
		System.out.println(trailingZeroes(25));

	}

}
