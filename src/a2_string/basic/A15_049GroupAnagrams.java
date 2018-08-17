package a2_string.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 *    [
 *      ["ate","eat","tea"],
 *      ["nat","tan"],
 *      ["bat"]
 *    ]
 *    
 *    
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 * @author William
 *
 */
public class A15_049GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}
			String ns = String.valueOf(arr);
			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				List<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}
	
 	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
