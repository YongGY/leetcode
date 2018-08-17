package a2_string.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * 
 * @author William
 *
 */
public class A04_387FirstUniqueCharacterInAString {

	public static int firstUniqChar(String s) {
		int[] temp = new int[26];
		for (int i = 0; i < s.length(); i++) {
			temp[s.charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(temp));
		for (int j = 0; j < s.length(); j++) {
			if (temp[s.charAt(j) - 'a'] == 1) {
				return j;
			}
		}
		return -1;
	}

 	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
