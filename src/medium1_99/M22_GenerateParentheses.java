package medium1_99;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: 
 * [ 
	  "((()))", 
	  "(()())", 
	  "(())()",
	  "()(())", 
	  "()()()" 
 * ]
 * 
 * @author William
 *
 */
public class M22_GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		helper(n, n, "", res);
		return res;
	}

	public void helper(int left, int right, String out, List<String> res) {
		if (left < 0 || right < 0 || left > right)
			return;
		if (left == 0 && right == 0) {
			res.add(out);
			return;
		}
		helper(left - 1, right, out + "(", res);
		helper(left, right - 1, out + ")", res);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
