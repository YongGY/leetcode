package string.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * @author William
 *
 */
public class A09_345ReverseVowelsOfAString {
	
	public static String reverseVowels(String s) {
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');

		int left = 0;
		int right = s.length() - 1;
		char[] arr = s.toCharArray();

		while (left < right) {
			char ll = arr[left];
			char rr = arr[right];
			
			if (!set.contains(ll)) {
				left++;
				continue;
			}
			if (!set.contains(rr)) {
				right--;
				continue;
			}
			arr[left] = rr;
			arr[right] = ll;
			left++;
			right--;
		}
		return String.valueOf(arr);
	}	
	
 	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}
}
