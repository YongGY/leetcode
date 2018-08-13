package string.palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * 
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * 
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * 
 * @author William
 * 
 * https://segmentfault.com/a/1190000008917798
 *
 */
public class A06_336PalindromePairs {


    /**
     * 暴力解法就不赘述了，找出所有pairs，逐一验证isPalindrome. 时间复杂度O(N^2*k).
     *
     * palindrome最大的特性就是对称，按长度的奇偶可以分为str,char,reverse(str)还有 str,reverse(str)型。
     *
     * 我们有一个str,在i这个位置进行切分，得到的前半部分是一个palindrome.
     * 比如"lls", 变成"ll", "s". 已知"ll"是palindrome，我们只需要知道reverse("s") 放到前边就可以了。
     * reverse("s")"ll""s", 即reverse(str) PalindromeSubString str的类型。
     *
     * 还有一种就是后半部分是palindrome, 我们找到前半部分的reverse,拼到后面。["abcdc", "ba"]。
     * "cdc"是palindrome, reverse(ab) 就是 "ba", 我们有这样的string出现过。
     *
     * 代码细节就是有一个isPalindrome的helper function。 一个hashmap存入所有<string, idx> paris加速查询。
     * 容易出bug的两个地方, 以["abcd", "dcba", "lls", "s", "sssll"]为例。
     * 1. 如果一个str本身就是panlindrome，reverse就是本身，一定在hashmap里，去重的方法就是判断map.get(reverse(str)) != i.
     *    [[1,0],[0,1],[3,2],[3,3],[2,4]]
     * 2. 我们在切割str的时候，j == 0 时str变成 "" 和 "str",  j == str.length()的时候str变成"str"和""。
     *    "abcd", "dcba"这两个互为reverse的string, 在"abcd"尾部加上"dcba"也就是在"dcba"头部加上"abcd".
     *    所以后部分不能为空，否则就和头部为空的情况重复了。
     *    [[1,0],[0,1],[0,1],[1,0],[3,2],[2,4]]
     *
     * 空间复杂度因为用了额外的hashmap来储存，需要O(N)空间。
     * 时间复杂度每个str分为两个部分，调用isPalindrome,前后两部分总长度为k. 所以每次调用为O(k)一共(k+1)次。
     * 然后一共有N个str, 总共时间复杂度为O(N*k^2).
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if(isPalindrome(str1)){
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rvs) && map.get(str2rvs) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(isPalindrome(str2) && str2.length() != 0){
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rvs) && map.get(str1rvs) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A06_336PalindromePairs().palindromePairs(new String[]{"a",""}));
    }
}
