package a1_array.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *This is a follow up of Shortest Word Distance. 
 *The only difference is now you are given the list of words 
 *and your method will be called repeatedly many times with different parameters. 
 *
 *How would you optimize it?
 *
 *Design a class which receives a list of words in the constructor, 
 *and implements a method that takes two words word1 and word2 
 *and return the shortest distance between these two words in the list.
 *
 *For example,
 *Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 *Given word1 = “coding”, word2 = “practice”, return 3.
 *Given word1 = "makes", word2 = "coding", return 1.
 *
 *Note:
 *You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * 
 * @author William
 *
 */
public class A244_ShortestWordDistanceII {

	HashMap<String, List<Integer>> map = new HashMap<>();

	public A244_ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

	public int shortest(String word1, String word2) {
		int shortest = Integer.MAX_VALUE; 
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		for (Integer l1 : list1) {
			for (Integer l2 : list2) {
				shortest = Math.min(shortest, Math.abs(l1 - l2));
			}
		}
		return shortest;
	}

	
	public static void main(String[] args) {
		A244_ShortestWordDistanceII a = new A244_ShortestWordDistanceII(new String[] {"practice", "makes", "perfect", "coding", "makes"});
	}
}
