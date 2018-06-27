package easy1_199;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * 
 * Example 1: Input: haystack = "hello", needle = "ll" Output: 2
 * 
 * Example 2: Input: haystack = "aaaaa", needle = "bba" Output: -1
 * 
 * @author yongguo
 *
 */
public class E028_Implement_strStr {
 
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i<= haystack.length() - needle.length(); i++ ){
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
		 

	public static void main(String[] args) {
		System.out.println(strStr("heeeeello", "ll"));
		//System.out.println(strStr("aaaaa", "bba"));
	}

}
