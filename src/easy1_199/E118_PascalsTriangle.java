package easy1_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
 * ]
 * 
 * @author William
 * 
 * 除每行最左側與最右側的數字以外，每个数字等于它的左上方與右上方两个数字之和
 * 
 */
public class E118_PascalsTriangle {


	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return res;
		}
		List<Integer> one = new ArrayList<Integer>();
		one.add(1);
		res.add(one);
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> line = new ArrayList<Integer>();
			// 加入第一个1
			line.add(1);
			// 加入中间的数 (除去第一行和第二行才进这个循环)
			for (int j = 1; j < i; j++) {
				List<Integer> prevRow = res.get(i - 1);// 当前行的上一行
				line.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			// 加入最后一个1
			line.add(1);
			res.add(line);
		}
		return res;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));
	}

}
