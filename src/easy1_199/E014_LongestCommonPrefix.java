package easy1_199;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author yongguo
 *
 */
public class E014_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		//prefix表示目前发现的共同字首，一开始为strs[0]
		String prefix = strs[0];
		//只需要比对prefix跟目前字串共同的字元就好
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
		// TODO Auto-generated method stub
		System.out.println(longestCommonPrefix(new String[]{"abcdefg", "abcdefghijk", "abcdfghijk", "abcef"}));
	}

}
