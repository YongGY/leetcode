package a2_string.palindrome;

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
public class A214_ShortestPalindrome {
	
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
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    /**
     * https://ithelp.ithome.com.tw/articles/10185126
     * (反轉字串 - 最長匹配字串 ) + 正常字串 = 最短回文字串
     * (dcba - a ) + abcd = dcbabcd
     */

    //KMP算法
    public String shortestPalindrome1(String s) {
        String s_reverse = new StringBuilder(s).reverse().toString();
        String str = s + "#" + s_reverse;
        int[] size = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int temp = size[i - 1];
            while (temp != 0 && str.charAt(temp) != str.charAt(i)) {
                temp = size[temp - 1];
            }
            if (str.charAt(temp) == str.charAt(i)) {
                temp++;
            }
            size[i] = temp;
        }
        return s_reverse.substring(0, s.length() - size[str.length() - 1]) + s;
    }




 	public static void main(String[] args) {
 		System.out.println();
	}
}
