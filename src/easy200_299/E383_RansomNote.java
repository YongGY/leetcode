package easy200_299;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 */

public class E383_RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		 Map<Character,Integer> map = new HashMap<>();
		 for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c,  1);
			}
		 }
		 
		 for (int i = 0; i < ransomNote.length(); i++) {
			 char c = ransomNote.charAt(i);
			 if(map.containsKey(c)) {
				 map.put(c, map.get(c) - 1);
				 if(map.get(c) < 0) {
					 return false;
				 }
			 }else {
				 return false;
			 }
		 }
		return true;
		 
	}
 
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
		System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
 	}
}
