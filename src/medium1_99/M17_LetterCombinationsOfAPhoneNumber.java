package medium1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf","cd","ce", "cf"].
 * 
 * @author William
 * 
 * 深度优先搜索 
 * 
 * 复杂度时间 O(N) 空间 O(N) 递归栈空间
 * 
 * 思路
 * 首先建一个表，来映射号码和字母的关系。然后对号码进行深度优先搜索，对于每一位，从表中找出数字对应的字母，这些字母就是本轮搜索的几种可能。
 * 
 * 注意 
 * 用StringBuilder构建临时字符串 
 * 当临时字符串为空时，不用将其加入结果列表中
 *
 */
public class M17_LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		String[] ss = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		List<String> ret = new ArrayList<String>();
		rec(ret, digits.length(), ss, digits, new StringBuffer());
		return ret;
	}

	public static void rec(List<String> ret, int remain, String[] ss, String digits, StringBuffer sb) {
		// 说明对digits遍历结束
		if (remain == 0) {
			ret.add(sb.toString()); // 找到一种结果，加入列表中
			return;
		}

		String s = ss[digits.charAt(0) - '0'];// 得到digits[0]对应的string s
		System.out.println(digits.charAt(0) +"     "+s);
		// DFS 对每个可能字母进行搜索
		for (int i = 0; i < s.length(); i++) {
			sb = sb.append(s.charAt(i));
			rec(ret, remain - 1, ss, digits.substring(1), sb);
			sb.deleteCharAt(sb.length() - 1); // 恢复现场
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
		//System.out.println('2'-'0');
	}

}
