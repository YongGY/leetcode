package easy200_299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example,
 * 
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 */

public class E205_IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(map.containsKey(sc)){
                // 如果已经给s中的字符建立了映射，检查该映射是否和当前t中字符相同
                if(tc != map.get(sc)) return false;
            } else {
                // 如果已经给t中的字符建立了映射，就返回假，因为出现了多对一映射
                if(set.contains(tc)) return false;
                map.put(sc, tc);
                set.add(tc);
            }
        }
        return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab", "aa"));
	}
}
