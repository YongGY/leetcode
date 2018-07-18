package difficulty.easy200_399;

import java.util.HashSet;
/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 
 * 8^2 + 2^2 = 68 
 * 6^2 + 8^2 = 100 
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 题目大意 
 * 对任意一个正整数，不断求个数位上数字的平方和，若最终收敛为1，则该数字为happy number，否则程序可能从某个数开始陷入循环。
 * 
 * 解题思路 
 * 对这个数字的每个数位求平方和，如果如和为1或者平方和是之前出现过的就不进行求和，根据最后的结果判断是不是一个开心数字。
 */

public class E202_HappyNumber {

	public static boolean isHappy(int n) {
		if (n < 1) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();

		while (n != 1 && !set.contains(n)) {
			set.add(n);
			int newN = 0;
			while (n > 0) {
				newN += (n % 10) * (n % 10);
				n /= 10;
			}
			n = newN;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
 	}
}
