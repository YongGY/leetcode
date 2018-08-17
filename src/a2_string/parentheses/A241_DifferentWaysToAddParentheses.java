package a2_string.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class A241_DifferentWaysToAddParentheses {

	//可加 可不加  加去重复 效率高
	Map<String, List<Integer>> map = new HashMap<>();

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
		if (res.size() == 0) {
			res.add(Integer.parseInt(input));
		}
		map.put(input, res);
		return res;
	}

 	public static void main(String[] args) {
 		System.out.println(new A241_DifferentWaysToAddParentheses().diffWaysToCompute("2-1-1"));
	}
}


