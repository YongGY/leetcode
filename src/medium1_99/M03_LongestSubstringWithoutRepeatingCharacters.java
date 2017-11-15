package medium1_99;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * 第一个问题，怎么表示子串呢？
 * 这里就可以联想到两个指针，慢指针指向子串的头部，快指针指向子串的尾部。
 * 
 * 第二个问题，怎么存储子串呢？
 * 题目要求，不含重复字符，我们可以联想到 Set。
 * 进一步，我们使用 HashSet就够了，把两个指针之间的字符元素全部存入这个 Set。
 * 
 * 第三个问题，怎么找出最大子串呢？
 * 当然是比较长度了，我们设一个变量 max，来存放当前子串长度，初始值为 0。
 * 我们在遍历字符串的过程中，如果某字符在集合中不存在，那么比较当前的 max 值 和添加该元素后的 set 大小，取最大值存入 max。
 * 
 * 最后问题，遇到重复元素如何处理？
 * 因为子串是连续的，我们在遇到重复元素的时候只能从子串头部开始删，也就是将 i 位置的元素从集合中删掉，指针后移一位。
 * 
 * 
 * 快慢指针O(N)解法：快指针j、慢指针i。 快指针 j 检查 j 位置字符是否在在HashSet中
 * 
 * 不在的话，就继续向右移动 j 指针， 并更新最大长度。
 * 若在的话，则删除HashSet头部字符，即 i 所在位置字符，并移动 i 指针。
 * @author William
 *
 */
public class M03_LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring("bbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
