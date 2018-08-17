package a2_string.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
 * "pwke" is a subsequence and not a substring.
 * 
 * 
 * @author William
 *
 */
public class A003_LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) != null) {
				start = Math.max(start, map.get(c) + 1);
			}
			map.put(c, i);//更新重复出现数的index值
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
    
	public int lengthOfLongestSubstring2(String s) {
		int result = 0;
		int[] cache = new int[256];
		for (int i = 0, j = 0; i < s.length(); i++) {
			j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
			// 注意因为stirng的index是从0开始，但是我们判断这个字母是否在cache里也用这个字母的cache值是否来判断，
			// 所以我们把每个存进cache里的字母的index + 1, 这样存的就是它的下一个数的index。
			cache[s.charAt(i)] = i + 1;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}

 	public static void main(String[] args) {
 		
	}
}
