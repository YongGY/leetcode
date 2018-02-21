package easy200_399;


/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, 
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 */

public class E242_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
        	return false;
        }
        for (char i = 'a'; i <= 'z'; i++) {
        	String str = String.valueOf(i);
        	System.out.println(str);
			int sLen = s.replaceAll(str, "").length();
			int tLen = t.replaceAll(str, "").length();
			if(sLen != tLen) {
				return false;
			}
		}
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isAnagram("ab", "ba"));
	}
}
