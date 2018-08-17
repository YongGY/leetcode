package a3_math.basic;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * @author William
 *
 * 主要思路是:
 *
 * 两数相乘，结果的长度不会大于两数长度和m + n，所以一开始我们开一个int[] res = new int[m + n]
 * 接下来对num1和num2做一个双重循环从后向前遍历
 * 当前的 digit1 = num1.charAt(i) - '0'，  digit2 = num2.charAt(j) - '0'
 *
 * 这时我们可以更新当前res[i + j + 1]的这个位置为原来存在这一位置上的值再加上新的值digits1 * digit2，简略一下就是 res[i + j + 1] += digits1 * digit2
 * 接下来根据res[i + j + 1]的新值，我们可以更新高一位的res[i + j]，  res[i + j] += res[i + j + 1] / 10，就是本来的值加上进位
 * 最后我们再用res[i + j + 1] %= 10求出这一位置进位后剩下的digit
 *
 * 求出res数组之后我们可以建立一个StringBuilder sb，来从头遍历数组，求出最终结果
 * 要注意的是当sb.length() == 0并且res[i] = 0时，这时候是开头的0值，需要跳过
 * 假如遍历完毕以后sb.length()依然等于0， 我们返回"0"
 *
 */
public class A043_MultiplyStrings {
	public static String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];//计算乘积与进位之和
				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int p : pos) {
			if (sb.length() == 0 && p == 0) {
				continue;
			}
			sb.append(p);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

 	public static void main(String[] args) {
 		System.out.println(multiply("123","45"));
	}
}
