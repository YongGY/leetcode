package test;

public class W006_FindTheLongestPalindrome {

	/**
	 * Find longest palindrome formed by removing or shuffling chars from string
	 * Given a string, find the longest palindrome that can be constructed by removing or shuffling characters from the string. 
	 * Return only one palindrome if there are multiple palindrome strings of longest length.
	 * 
	 * Examples:
	 * 
	 * Input:  abc
	 * Output: a OR b OR c
	 * 
	 * Input:  aabbcc
	 * Output: abccba OR baccab OR cbaabc OR
	 * any other palindromic string of length 6.
	 * 
	 * Input:  abbaccd
	 * Output: abcdcba OR ...
	 * 
	 * Input:  aba
	 * Output: aba
	 */
	
	public static String findTheLongestPalindrome(String str) {
		if (str == null) {
			return null;
		}

		// Count array to store count of charcters
		int[] count = new int[256];
		
	    // find frequency of characters in the input string
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
		
		// Any palindromic string consists of three parts beg + mid + end		
		String start = "", mid = "", end = "";
		
	    // solution assumes only lowercase characters are present in string. 
		// We can easily extend this to consider any set of characters
		for (char ch = 'a'; ch <= 'z'; ch++) {
			
			// if the current character freq is odd
			if (count[ch] % 2 == 1) {
				
		        // mid will contain only 1 character. 
				// It will be overridden with next character with odd frequency
				mid = String.valueOf(ch);
				
	            // decrement the character frequency to make it even and consider current character again
				count[ch--]--;
				
			} else {        // if the current character freq is even

		        // If count is n(an even number), push n/2 characters to beg string and 
				// rest n/2 characters will form part of end string
				for (int i = 0; i < count[ch] / 2; i++) {
					start += String.valueOf(ch);
				}
			}
		}
		end = start;
		// end will be reverse of start
		end = new StringBuffer(end).reverse().toString();
		
	    // return palindrome string
		return start + mid + end;
	}

	public static void main(String[] args) {
		System.out.println(findTheLongestPalindrome("abc"));
		System.out.println(findTheLongestPalindrome("aabbcc"));
		System.out.println(findTheLongestPalindrome("abbaccd"));
		System.out.println(findTheLongestPalindrome("aba"));
	}
		
	
}
