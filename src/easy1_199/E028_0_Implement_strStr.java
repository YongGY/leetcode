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
public class E028_0_Implement_strStr {

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() == 0) {
			return 0;
		}
		
		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length()) {
				return -1;
			}

			int m = i;
			for (int j = 0; j < needle.length(); j++) {
				if (needle.charAt(j) == haystack.charAt(m)) {
					if (j == needle.length() - 1) {
						return i;
					}
					m++;
				} else {
					break;
				}
			}
		}
		return -1;
		
		
		
		
		
//		// 从heystack开始
//		for (int i = 0;; i++) {
//			// 匹配needle的字符
//			for (int j = 0;; j++) {
//				// 如果needle和j一样长，则直接返回i(当前匹配的起始位置)，因为已经匹配成功了
//				if (j == needle.length()) {
//					return i;
//				}
//				// 如果i+j为当前haystack的长度，则表明已经走完heystack所有的字符，并且没有匹配成功(注意如果最后一个字符正好匹配成功，则在上面一个判断就会返回)
//				if (i + j == haystack.length()) {
//					return -1;
//				}
//				// 如果当前needle和haystack的字符相同的话(因为每次不成功匹配不成功，则i移动1位，而j又重新从0开始，所以haystack的当前位置是i+j)
//				if (needle.charAt(j) != haystack.charAt(i + j)) {
//					break;
//				}
//			}
//		}
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
	}

}
