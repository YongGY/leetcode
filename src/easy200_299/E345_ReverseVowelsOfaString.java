package easy200_299;


/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1: Given s = "hello", return "holle".
 * 
 * Example 2: Given s = "leetcode", return "leotcede".
 * 
 * Note: The vowels does not include the letter "y"..
 * 
 */

public class E345_ReverseVowelsOfaString {

    
	public static String reverseVowels(String s) {
		
		String vowelsStr = "aeiouAEIOU";

		int lo = 0;
		int hi = s.length() - 1;
		char[] ch = s.toCharArray();
		
		while (lo < hi) {

			if (!vowelsStr.contains(String.valueOf(s.charAt(lo)))) {
				lo++;
				continue;
			}

			if (!vowelsStr.contains(String.valueOf(s.charAt(hi)))) {
				hi--;
				continue;
			}

			char temparray = ch[lo];
			ch[lo] = ch[hi];
			ch[hi] = temparray;
			
			lo++;
			hi--;
		}
		
		return String.valueOf(ch);
		
 
		
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
	}
}
