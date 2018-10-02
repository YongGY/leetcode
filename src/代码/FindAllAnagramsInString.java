	/**
	 * Find All Anagrams in a String 
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return result;
		}
		// sliding window
		Map<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}
		int total = p.length();
		for (int l = 0, r = 0; r < s.length(); r++) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count current hash value >= 1 means the character is
			// existing in p
			char c = s.charAt(r);
			Integer count = counts.get(c);
			if (count != null) {
				if (count >= 1) {
					total--;
				}
				counts.put(c, count - 1);
			}
			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (total == 0) {
				result.add(l);
			}
			if (r - l == p.length() - 1) {
				c = s.charAt(l++);
				count = counts.get(c);
				if (count != null) {
					if (count >= 0) {
						total++;
					}
					counts.put(c, count + 1);
				}
			}
		}
		return result;
	}

    public List<Integer> findAnagrams2(String s, String p) {
 		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return result;
		}
		int[] hash = new int[256]; // character hash
		// record each character in p to hash
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right++)]-- >= 1) {
				count--;
			}

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0) {
				result.add(left);
			}

			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
				count++;
			}
		}
		return result;
    }
