package a2_string.basic;

/**
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * 首先编辑距离的定义搞清楚是什么，就是两个string之间差异只有一个digit，接下来对问题进行分析：
 * 	1. 如果两个string相等，则返回false；
 * 	2. 如果两个string长度一致，那么他们之间只有一个char不相同，找到第一个不相同的char，如果两者的后半截都相等，那么成立；
 * 	3. 如果两个string长度相差大于1，则返回false；
 * 	4. 如果两个string长度相差为1，那么长的那个string比短的string多出一个char，找到那个不一样的char之后，长的char最后半截和短的char后半截相等，则成立；
 * 
 * @author William
 * 
 * 题目描述
 * 给定两个字符串 s 和 t，判断它们的编辑距离是否为1。
 * 
 * 注意：
 * 编辑距离为1有三种情况：
 * 
 * 在 s 中插入一个字符可以得到 t；
 * 在 s 中删除一个字符可以得到 t；
 * 将 s 中的一个字符替换掉可以得到 t；
 * 
 * 样例1
 * 输入：s = "ab", t = "acb"
 * 输出：true
 * 解释：在s中插入'c'可以得到t。
 * 
 * 样例2
 * 输入：s = "cab", t = "ad"
 * 输出：false
 * 解释：对s只操作一步无法得到t。
 * 
 * 样例3
 * 输入：s = "1203", t = "1213"
 * 输出：true
 * 解释：将s中的0替换成1，可以得到t。
 * 
 * 算法
 * (扫描数组) O(n)
 * 
 * 分三种情况考虑：
 * 字符串长度之差大于1，则编辑距离一定大于1，返回false；
 * 字符串长度相等，则有且只有一个字符不同时，才返回true；
 * 字符串长度差1，则只需判断短字符串是否是长字符串的子序列即可：
 * 		用指针 i 指向短字符串开头(不妨设短字符串是 s，长字符串是 t)，
 * 		然后扫描长字符串，如果当前字符等于 s[i]，则令 i 加1。
 * 		如果最终 i 能遍历完 s，则 s 就是 t 的子序列；
 * 
 * 时间复杂度分析：三种情况都只需将两个字符串遍历一次，所以时间复杂度是 O(n)。
 *
 */
public class A20_161OneEditDistance {
	
	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if (m == n)
			return isOneModified(s, t);
		if (m - n == 1)
			return isOneDeleted(s, t);
		if (n - m == 1)
			return isOneDeleted(t, s);
		// 长度差距大于2直接返回false
		return false;
	}

	private static boolean isOneModified(String s, String t) {
		int count = 0;
		// 看是否只修改了一个字符
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (++count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isOneDeleted(String longer, String shorter) {
		// 找到第一组不一样的字符，看后面是否一样
		for (int i = 0; i < shorter.length(); i++) {
			if (longer.charAt(i) != shorter.charAt(i)) {
				return longer.substring(i + 1).equals(shorter.substring(i));
			}
		}
		return true;
	}
	
 	public static void main(String[] args) {
		System.out.println(isOneEditDistance("1203","1213"));
	}
}
