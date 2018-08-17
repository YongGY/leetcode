package a2_string.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author William
 *
 */
public class A340_LongestSubstringWithAtMostKDistinctCharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null)
			return 0;
		int from = 0;
		int[] histogram = new int[256];
		int distinct = 0;
		char[] sa = s.toCharArray();
		int max = 0;
		for (int i = 0; i < sa.length; i++) {
			if (histogram[sa[i]] == 0) {
				distinct++;
			}
			histogram[sa[i]]++;
			
			while (distinct > k) {
				histogram[sa[from]]--;
				if (histogram[sa[from]] == 0) {
					distinct--;
				}
				from++;
			}
			
			max = Math.max(max, i - from + 1);
		}
		return max;
	}

	
	public  static int lengthOfLongestSubstringKDistinct2(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			// character at the right pointer
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			// make sure map size is valid, no need to check left pointer less than s.length()
			while (map.size() > k) {
				char leftChar = s.charAt(left);
				if (map.containsKey(leftChar)) {
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
				}
				left++;
				System.out.println(map);
				
			}
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
	
    
 	public static void main(String[] args) {
 		System.out.println(lengthOfLongestSubstringKDistinct2("eceba", 2));
	}
}
