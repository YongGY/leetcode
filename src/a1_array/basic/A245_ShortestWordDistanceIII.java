package a1_array.basic;

/**
 *This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 *
 *Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 *word1 and word2 may be the same and they represent two individual words in the list.
 *
 *For example,
 *Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 *Given word1 = “makes”, word2 = “coding”, return 1.
 *Given word1 = "makes", word2 = "makes", return 3.
 *
 *Note:
 *You may assume word1 and word2 are both in the list.
 * 
 * @author William
 *
 */
public class A245_ShortestWordDistanceIII {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null)
			return -1;

		boolean isSame = false;

		if (word1.equals(word2))
			isSame = true;

		int shortest = Integer.MAX_VALUE;

		int prev = -1;
		int idx1 = -1;
		int idx2 = -1;

		for (int i = 0; i < words.length; i++) {
			if (isSame) {
				if (words[i].equals(word1)) {
					if (prev != -1) {
						shortest = Math.min(shortest, i - prev);
					}
					prev = i;
				}
			} else {
				if (word1.equals(words[i])) {
					idx1 = i;
					if (idx2 != -1) {
						shortest = Math.min(shortest, i - idx2);
					}
				} else if (word2.equals(words[i])) {
					idx2 = i;
					if (idx1 != -1) {
						shortest = Math.min(shortest, i - idx1);
					}
				}
			}
		}
		return shortest;
	}
}
