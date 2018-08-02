package backtracking.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Examples:
 *
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * @author William
 *
 */
public class A13_291WordPatternII {

	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return match(pattern, 0, str, 0, map, set);
	}

	private boolean match(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
		// base case
		if (i == pattern.length() && j == str.length()) return true;
		if (i == pattern.length() || j == str.length()) return false;

		// 如果pattern出现过，必须char,pattern映射必须唯一。
		// 如果映射正确，go deeper
		Character c = pattern.charAt(i);
		if (map.containsKey(c)) {
			String s = map.get(c);
			if (!str.startsWith(s, j)) {
				return false;
			}
			return match(pattern, i + 1, str, j + s.length(), map, set);
		}

		// 不断尝试pattern，返回可能的情况，有一种情况成立，就是全局成立。
		for (int k = j; k < str.length(); k++) {
			String sub = str.substring(j, k + 1);
			if (set.contains(sub)) continue;

			map.put(c, sub);
			set.add(sub);

			if (match(pattern, i + 1, str, k + 1, map, set)) {
				return true;
			}

			map.remove(c);
			set.remove(sub);
		}

		return false;
	}

 	public static void main(String[] args) {
 		
	}
}
