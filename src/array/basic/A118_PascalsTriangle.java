package array.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * 
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @author William
 *
 */
public class A118_PascalsTriangle {
	 
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows <= 0) {
			return res;
		}
		List<Integer> one = new ArrayList<Integer>();
		one.add(1);
		res.add(one);
		
		for(int i=1; i<numRows; i++) {
			List<Integer> line = new ArrayList<Integer>();
			line.add(1);
			List<Integer> preRowList = res.get(i - 1);
			for(int j=1; j<i; j++) {
				line.add(preRowList.get(j-1)+preRowList.get(j));
			}
			line.add(1);
			res.add(line);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(6));
	}
}
