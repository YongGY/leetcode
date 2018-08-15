package string.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * 
 * @author William
 *
 */
public class A076_MinimumWindowSubstring {

	/**
	 * 双指针法
	 * 复杂度
	 * 时间 O(N) 空间 O(1)
	 *
	 * 思路
	 * 用一个哈希表记录目标字符串每个字母的个数，一个哈希表记录窗口中每个字母的个数。先找到第一个有效的窗口，用两个指针标出它的上界和下界。
	 * 然后每次窗口右界向右移时，将左边尽可能的右缩，右缩的条件是窗口中字母的个数不小于目标字符串中字母的个数。
	 *
	 * 注意
	 * 用一个数组来保存每个字符出现的次数，比哈希表容易
	 *
	 * 保存结果子串的起始点初值为-1，方便最后判断是否有正确结果
	 */

	public String minWindow(String s, String t) {
		int[] srcHash = new int[255];
		// 记录目标字符串每个字母出现次数
		for (int i = 0; i < t.length(); i++) {
			srcHash[t.charAt(i)]++;
		}
		int start = 0;
		int i = 0;
		// 用于记录窗口内每个字母出现次数
		int[] destHash = new int[255];
		int found = 0;
		int begin = -1, end = s.length(), minLength = s.length();
		for (start = i = 0; i < s.length(); i++) {
			// 每来一个字符给它的出现次数加1
			destHash[s.charAt(i)]++;
			// 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
			if (destHash[s.charAt(i)] <= srcHash[s.charAt(i)]) found++;
			// 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
			if (found == t.length()) {
				// 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
				while (start < i && destHash[s.charAt(start)] > srcHash[s.charAt(start)]) {
					destHash[s.charAt(start)]--;
					start++;
				}
				// 这时候start指向该子串开头的字母，判断该子串长度
				if (i - start < minLength) {
					minLength = i - start;
					begin = start;
					end = i;
				}
				// 把开头的这个匹配字符跳过，并将匹配字符数减1
				destHash[s.charAt(start)]--;
				found--;
				// 子串起始位置加1，我们开始看下一个子串了
				start++;
			}
		}
		// 如果begin没有修改过，返回空
		return begin == -1 ? "" : s.substring(begin, end + 1);
	}









	public String minWindow1(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			Integer count = map.get(c);
			if (count == null) {
				map.put(c, 1);
			} else {
				map.put(c, count + 1);
			}
		}

		int index = 0;
		int slow = 0;
		int minLen = s.length() + 1;
		int matchCount = 0;

		for (int fast = 0; fast < s.length(); fast++) {
			char c = s.charAt(fast);
			Integer count = map.get(c);
			if (count == null) {
				continue;
			}
			map.put(c, count - 1);
			// match another character
			if (count == 1) {
				// 1->0
				matchCount++;
			}

			while (matchCount == map.size()) {
				// find a valid substring
				if (fast - slow + 1 < minLen) {
					minLen = fast - slow + 1;
					index = slow;
				}
				char leftMost = s.charAt(slow++);
				Integer leftMostCount = map.get(leftMost);
				if (leftMostCount == null) {
					continue;
				}
				map.put(leftMost, leftMostCount + 1);
				if (leftMostCount == 0) {
					// 0 -> 1
					matchCount--;
				}
			}
		}
		return minLen == s.length() + 1 ? "" : s.substring(index, index + minLen);

	}


	public String minWindow3(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap(); //<char, count of char in t>
		int start = 0;
		int end = 0; //two pointers, one point to tail and one  head
		int minStart = 0;//track the start pos of min string
		int minLen = Integer.MAX_VALUE; //the length of min string
		int counter = t.length(); // counter represents the number of chars of t to be found in s.
		/* initialize the hash map here */
		for (char c : s.toCharArray()) {
			map.put(c, 0);
		}
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				return "";
			}
		}

		while (end < s.length()) {
			char cur = s.charAt(end);
			/* modify counter here */
			if (map.get(cur) > 0) {
				counter--;//if cur is in t
			}
			map.put(cur, map.get(cur) - 1);
			/* counter condition --find a valid window */
			while (counter == 0) {
				/* update minLen here if finding minimum*/
				if (minLen > end - start + 1) {
					minStart = start;
					minLen = end - start + 1;
				}
				//set back map and counter & move forwards start till invalid
				/*modify counter here*/
				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);
				if (map.get(c2) > 0) {
					counter++;//set counter back only for char in t
				}
				start++;
			}
			end++;
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

 	public static void main(String[] args) {
 		
	}
}
