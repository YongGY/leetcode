package a2_string.basic;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author William
 *
 */
public class A01_028ImplementStrStr {
	
	
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() == 0)
			return 0;
		if (needle.length() > haystack.length())
			return -1;

		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
	

	public int strStr1(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() == 0)
			return 0;
		if (needle.length() > haystack.length())
			return -1;
		
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean boo = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					boo = false;
					break;
				}
			}
			if (boo)
				return i;
		}
		return -1;
	}
    
 	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
	}
}
