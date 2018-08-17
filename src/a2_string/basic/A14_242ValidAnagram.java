package a2_string.basic;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * @author William
 *
 */
public class A14_242ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;

		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}
		for (int i : arr) {
			if (i != 0)
				return false;
		}

		return true;
	}
	
 	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
	}
}
