package easy200_299;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false. 
 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
 * pattern = "abba", str = "dog dog dog dog" should return false. 
 * 
 * Notes: You may assume pattern contains only lowercase letters, 
 * and str contains lowercase letters separated by a single space.
 */

public class E290_WordPattern {

    public static boolean wordPattern(String pattern, String str) {
 
    	Map<Character, String> map = new HashMap<>();
    	String[] strs = str.split(" ");
    	if(pattern.length() != strs.length) {
    		return false;
    	}
    	
    	for (int i = 0; i < strs.length; i++) {
    		if(map.containsKey(pattern.charAt(i)) ) {
    			if(!strs[i].equals( map.get(pattern.charAt(i))) ) {
    				return false;
    			}
    		}else if(map.containsValue(strs[i]) ) {
    			return false;
    		}
			 map.put(pattern.charAt(i), strs[i]);
		}
		return true;
    }

    
    public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}
}
