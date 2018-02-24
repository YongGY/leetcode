package easy1_199;

import javax.net.ssl.SSLContext;

/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth term
 * of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1: Input: 1 Output: "1"
 * 
 * Example 2: Input: 4 Output: "1211"
 * 
 * @author yongguo
 *
 */
public class E038_CountAndSay {

	/**
	 * 这道题目相对比较容易，也不牵扯什么算法。只需要扫描字符串，计数，输出，即可。
	 * 
	 * 比如我们再扫描1211的时候，看1后面是2，则1的count = 1，则将count + 1 写入字符串中，2也一样，2后面的1,1后面还是1，则count++，第二个1后面没有了，则将count+1写入字符串，输入完毕。
	 * 
	 * 因此打印的就是11+12+21即111221。
	 * 
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		String s = "1";
		int num = 1;
		for (int i = 0; i < n - 1; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				if (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
					num++;
				} else {
					sb.append(num + "" + s.charAt(j));
					num = 1;
				}
			}
			s = sb.toString();
		}
		return s;
	}
	
	
	public static void main(String[] args) {
		// System.out.println(countAndSay(1));
		// System.out.println(countAndSay(2));
		// System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		// System.out.println(countAndSay(5));
		// System.out.println(countAndSay(6));
	}

}
