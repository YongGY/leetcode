package difficulty.easy200_399;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 */

public class E387_FirstUniqueCharacterInAString {

	public static int firstUniqChar(String s) {
		Map<Character,Integer> map = new LinkedHashMap();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1 + s.length());
			}else {
				map.put(c, i);
			}
		}
		for (Character key : map.keySet()) {
			if(map.get(key) <= s.length()) {
				return map.get(key);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
