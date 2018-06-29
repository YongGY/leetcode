package array.basic;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * 
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list。
 * 
 * @author William
 *
 */
public class A15_243ShortestWordDistance {
	public static int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0)
			return -1;
		int idx1 = -1, idx2 = -1, shortest = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i] == word1) {
				idx1 = i;
				if (idx2 != -1) {
					shortest = Math.min(shortest, idx1 - idx2);
				}
			} else if (words[i] == word2) {
				idx2 = i;
				if (idx1 != -1) {
					shortest = Math.min(shortest, idx2 - idx1);
				}
			}
		}
		return shortest;
	}
	
	public static void main(String[] args) {
		System.out.println(shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
		System.out.println(shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
	}
}
