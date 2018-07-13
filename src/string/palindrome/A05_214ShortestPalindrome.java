package string.palindrome;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * Example 1:
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * Example 2:
 * Input: "abcd"
 * Output: "dcbabcd"
 * 
 * @author William
 *
 */
public class A05_214ShortestPalindrome {
	
//	题解：
//
//	KMP ?  Manacher ?  Suffix Array?
//
//	猜想 - 找到以s.charAt(0)开始的最长的palindrome，然后再用s.length()减去这个长度，就是我们需要添加的字符长度。这时候我们再在原String之前添加就可以了。
//
//	假设s = "bcba"，那么以s.charAt(0)为左边界的longest palindrome是"bcb"，需要添加的是"a"，返回"abcba"。
//
//	假设s = "bba"，那么以s.charAt(0)为左边界的longest palindrome是"bb"，需要添加的是"a"，返回"abba"。
//
//	假设s = "bcd"，那么以s.charAt(0)为左边界的longest palindrome长度为"b"，需要添加的是"cd"，返回"dcbcd"。
//
//	这样把问题转化为求以s.charAt(0)为起点的longest palindrome问题。 接下来就是coding了，应该可以用Manacher或者KMP在O(n)解决，晚上回家再试写。 
//	假如不是只在左边添加，而是哪里都可以插入的话，那么就和Edit Distance很像，应该能够用DP解决。
//
//	又查了查，好像有些类似的问题叫做palindrome prefix。
//
//	Manacher:
//
//	稍微修改了一下自己在5. Longest Palindromic Substring的代码，最后求出P的时候，计算一下最长的prefix就可以了，代码略繁琐，二刷要好好再简化。

//http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
//http://massivealgorithms.blogspot.com/2015/09/leetcode-214-shortest-palindrome-iteye.html
    public String shortestPalindrome(String s) {
        
    }
    
 
 	public static void main(String[] args) {
 		
	}
}
