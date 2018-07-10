package string.basic;

/**
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 * @author William
 *
 */
public class A02_014LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < strs[i].length() && j < prefix.length() && prefix.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	
 	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
	}
}
