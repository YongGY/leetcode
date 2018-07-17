package string.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 *  (2*(3-(4*5))) = -34 
 *  ((2*3)-(4*5)) = -14 
 *  ((2*(3-4))*5) = -10 
 *  (2*((3-4)*5)) = -10 
 *  (((2*3)-4)*5) = 10
 * 
 * @author William
 *
 */
public class A04_241DifferentWaysToAddParentheses {
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		if (input == null || input.length() == 0)
			return res;
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int l : left) {
					for (int r : right) {
						if (c == '+')
							res.add(l + r);
						else if (c == '-')
							res.add(l - r);
						else
							res.add(l * r);
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.parseInt(input));
		return res;
	}
	
	
	
	

 	public static void main(String[] args) {
 		
	}
}


