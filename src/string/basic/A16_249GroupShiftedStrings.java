package string.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * 
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *   [
 *     ["abc","bcd","xyz"],
 *     ["az","ba"],
 *     ["acef"],
 *     ["a","z"]
 *   ]
 *   
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 * 
 * @author William
 *
 */
public class A16_249GroupShiftedStrings {
	
	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strings) {
			String key = "";
			for (int i = 1; i < str.length(); i++) {
				int offset = str.charAt(i) - str.charAt(i - 1);
				// 在为负数的时候，当经过z, a的时候，数值大小会很大得反转
				key += offset < 0 ? offset + 26 : offset;
			}
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}

		result.addAll(map.values());
		return result;
	}
	
 	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "dc"}));
	}
}
