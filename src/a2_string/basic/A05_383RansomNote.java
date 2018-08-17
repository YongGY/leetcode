package a2_string.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author William
 *
 */
public class A05_383RansomNote {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : magazine.toCharArray()) {
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) + 1);
			} else {
				freq.put(c, 1);
			}
		}
		for (char c : ransomNote.toCharArray()) {
			if (freq.containsKey(c)) {
				if (freq.get(c) > 1) {
					freq.put(c, freq.get(c) - 1);
				} else {
					freq.remove(c);
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean canConstruct2(String ransomNote, String magazine) {
		// 只有小写字母，分别申明保存2个字符串中26个字母依次出现的次数
		int[] a = new int[26];
		int[] b = new int[26];
		// a[]遍历保存ransomNote中26个字母出现的次数
		for (int i = 0; i < ransomNote.length(); i++) {
			a[ransomNote.charAt(i) - 'a']++;
		}
		// b[]遍历保存magazine中26个字母出现的次数
		for (int j = 0; j < magazine.length(); j++) {
			b[magazine.charAt(j) - 'a']++;
		}
		// 循环比较2个字符串中26个字母各自出现次数，如果数组a中某个字母出现次数大于b中对应字母的次数，则返回false
		for (int k = 0; k < 26; k++) {
			if (a[k] > b[k])
				return false;
		}
		return true;
	}
	
 	public static void main(String[] args) {
		System.out.println();
	}
}
