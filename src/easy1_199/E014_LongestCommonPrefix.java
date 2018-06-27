package easy1_199;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 * @author yongguo
 *
 */
public class E014_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(res) != 0) {
  				res = res.substring(0, res.length() - 1);
				if (res.isEmpty()) return "";			
			}
		}
		return res;
	}

	
	public static String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		// prefix表示目前发现的共同字首，一开始为strs[0]
		String prefix = strs[0];
		// 只需要比对prefix跟目前字串共同的字元就好
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
		// TODO Auto-generated method stub ["dog","racecar","car"]
//		System.out.println(longestCommonPrefix(new String[] { "abcdefg", "abcdefghijk", "abcdfghijk", "abcef" }));
		System.out.println(longestCommonPrefix(new String[] { "dog","racecar","car" }));
	}

}
