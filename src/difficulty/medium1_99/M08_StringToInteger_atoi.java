package difficulty.medium1_99;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author William
 * 
 *         通用方法 复杂度 时间 O(n) 空间 O(1)
 * 
 *         思路 字符串题一般考查的都是边界条件、特殊情况的处理。所以遇到此题一定要问清楚各种条件下的输入输出应该是什么样的。
 *         
 *         这里已知的特殊情况有：
 * 
 *         能够排除首部的空格，从第一个非空字符开始计算 
 *         允许数字以正负号(+-)开头
 *         遇到非法字符便停止转换，返回当前已经转换的值，如果开头就是非法字符则返回0 
 *         在转换结果溢出时返回特定值，这里是最大/最小整数 
 *         
 *         注意:检查溢出时最大整数要先减去即将加的最末位再除以10，来处理"2147483648"类似的情况
 *         可以参考glibc中stdlib/atoi.c的实现方法
 *
 */
public class M08_StringToInteger_atoi {

	public static int myAtoi(String str) {
		str = str.trim();
		int result = 0;
		boolean isPos = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (i == 0 && (c == '-' || c == '+')) {
				isPos = c == '+' ? true : false;
			} else if (c >= '0' && c <= '9') {
				// 检查溢出情况
				if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
					return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result *= 10;
				result += c - '0';
			} else {
				return isPos ? result : -result;
			}
		}
		return isPos ? result : -result;
	} 
	
	
	public static void main(String[] args) {
		System.out.println(myAtoi(" -1010023630"));
		System.out.println(myAtoi(" -1010023630o4"));
		System.out.println(myAtoi("    10522545459"));
		System.out.println(myAtoi("   123"));
		System.out.println(myAtoi("  -123"));
		System.out.println(myAtoi("  +123"));
		System.out.println(myAtoi("  -1234bbsf3"));
		System.out.println(myAtoi("  2147483646"));
		System.out.println(myAtoi("  2147483647"));
		System.out.println(myAtoi("  2147483648"));
		System.out.println(myAtoi("  2147483649"));
		System.out.println(myAtoi("  11111111111111111111111111111111111111111111111111"));
		System.out.println(myAtoi(" -2147483647"));
		System.out.println(myAtoi(" -2147483648"));
		System.out.println(myAtoi(" -2147483649"));
		System.out.println(myAtoi("  -11111111111111111111111111111111111111111111111111"));
		System.out.println(myAtoi("0"));
		System.out.println(myAtoi("abc"));

	}

}
