package string.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * 
 * For example, the numbers “69”, “88”, and “818” are all strobogrammatic.
 * 
 * @author William
 *
 */
public class A30_246StrobogrammaticNumber {
	
	public boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('8', '8');
		map.put('6', '9');
		map.put('9', '6');

		int i = 0;
		int j = num.length() - 1;

		while (i <= j) {
			char f = num.charAt(i);
			char b = num.charAt(j);
			if (map.containsKey(f) && map.containsKey(b) && map.get(f) == b) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
 	public static void main(String[] args) {
		System.out.println();
	}
}
