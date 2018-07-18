package difficulty.medium1_99;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @author William
 *
 */
public class M05_LongestPalindromicSubstring {

	/**
	 * 马拉车算法 Manacher Algorithm 复杂度 时间 O(n) 空间 O(n)
	 * 思路 Manacher算法是非常经典的计算连续下标回文的算法。它利用了回文的对称性，更具体的来说，是回文内回文的对称性，来解决这个问题。
	 * 参见：https://www.felix021.com/blog/read.php?2040
	 */
	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		// 预处理字符串，避免奇偶问题
		StringBuilder sb = new StringBuilder();
		sb.append("$");
		for (int i = 0; i < s.length(); i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");
		String str = sb.toString();
		System.out.println(str);
		// idx是当前能够向右延伸的最远的回文串中心点，随着迭代而更新
		// max是当前最长回文串在总字符串中所能延伸到的最右端的位置
		// maxIdx是当前已知的最长回文串中心点
		// maxSpan是当前已知的最长回文串向左或向右能延伸的长度
		int idx = 0, max = 0;
		int maxIdx = 0;
		int maxSpan = 0;
		int[] p = new int[str.length()];
		for (int curr = 1; curr < str.length(); curr++) {
			// 找出当前下标相对于idx的对称点
			int symmetryOfCurr = 2 * idx - curr;
			// 如果当前已知延伸的最右端大于当前下标，我们可以用对称点的P值，否则记为1等待检查
			p[curr] = max > curr ? Math.min(p[symmetryOfCurr], max - curr) : 1;
			// 检查并更新当前下标为中心的回文串最远延伸的长度
			while ((curr + p[curr]) < str.length() && str.charAt(curr + p[curr]) == str.charAt(curr - p[curr])) {
				p[curr]++;
			}
			// 检查并更新当前已知能够延伸最远的回文串信息
			if (curr + p[curr] > max) {
				max = p[curr] + curr;
				idx = curr;
			}
			// 检查并更新当前已知的最长回文串信息
			if (p[curr] > maxSpan) {
				maxSpan = p[curr];
				maxIdx = curr;
			}
		}
		// 去除占位符
		return s.substring((maxIdx - maxSpan) / 2, (maxSpan + maxIdx) / 2 - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestPalindrome("babad");
	}

}
