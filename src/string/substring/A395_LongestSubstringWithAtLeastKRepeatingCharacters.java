package string.substring;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 *
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output:3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 *
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output:5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * @author William
 *
 */
public class A395_LongestSubstringWithAtLeastKRepeatingCharacters {

	/**
	 * 要求是找出最长的子串，子串中的每一个字符都要重复至少k次。
	 *
	 * 思路是分治法。
	 *
	 * 要找s[i,j]的最大子串，先统计频数，然后遍历一遍频数，找出第一个频数小于k且大于0的字符，
	 * 然后找出这个字符的位置，接下来的分析很重要，这个字符一定不能出现在任何的子串中，
	 * 因为i,j是整个的子串，在ij里面频数都没有达到k，那么在ij的任何子串中，这个字符也不可能达到频数k。
	 *
	 * 所以不能有这个字符，那么就在这个位置做一个分治，返回前半部分和后半部分的最大值。
	 */

	/**
	 * 【分析】
	 *
	 * 用了一种递归的方法，从起初的一整个字符串，然后在k约束条件下递归搜索不满足条件的字符位置的左边字符串和右边的字符串，从而记录最大值
	 *
	 * 想一想还是比较巧妙的
	 *
	 * 比如：
	 *
	 * “abbcadda" 2
	 *
	 * step 1: str = "abbcadda" 不满足条件的字符为c，因为只有c不满足至少重复2次，所以递归索引左右边字符串"abb" ，”adda"
	 *
	 * ----------------------------------------------------------------------------左
	 *
	 * step 2: str1 = "abb"  不满足条件的字符为a，递归”“ 和”bb"
	 *
	 * ---------------------左
	 *
	 * step 3:str2 = ""
	 *
	 * ---------------------右
	 *
	 * step 4:str3 = "bb" 满足条件，maxlen = 2
	 *
	 * ----------------------------------------------------------------------------右
	 *
	 * step 5:str4 = "adda" 满足条件，maxlen = 4 > 2
	 *
	 * 所以maxlen = 4, 即“adda"
	 *
	 * --------------------------------------------------------------------------------------------------------------
	 */

	public static int longestSubstring(String s, int k) {
		if(s == null || s.length() == 0 || k > s.length())  {
			return 0;
		}
		int len = s.length();
		if(k < 2)  {
			return len;
		}
		return helper(0, len, s.toCharArray(), k);
	}

	private static int helper(int start, int end, char[] ch, int k){
		if(end - start < k)  {
			return 0;
		}
		int[] count = new int[26];
		for(int i = start; i < end; i++){
			count[ch[i] - 'a']++;
		}
		for(int i = start; i < end; i++){
			if(count[ch[i] - 'a'] < k){
				int left = helper(start, i, ch, k);
				int j = i + 1;
				while(j < end && count[ch[j] - 'a'] < k){
					j++;
				}
				int right = helper(j, end, ch, k);
				return Math.max(left, right);
			}
		}
		return end - start;
	}

	public static void main(String[] args) {
 		System.out.println(longestSubstring("aaabb",3));
	}
}
