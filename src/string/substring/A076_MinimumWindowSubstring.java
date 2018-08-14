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
	
	public String minWindow(String s, String t) {
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
    
    	
 	public static void main(String[] args) {
 		
	}
}
