package array.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0. In Pascal's triangle, each number is
 * the sum of the two numbers directly above it.
 * 
 * Example:
 * 
 * Input: 3 Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author William
 *
 */
public class A10_119PascalsTriangleII {
//    public static List<Integer> getRow(int rowIndex) {
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        for (int k = 1; k <= rowIndex; k++) {
//            for (int i = k - 1; i >= 1; i--) {
//                list.set(i, list.get(i) + list.get(i - 1));
//            }
//            list.add(1);
//        }
//        return list;
//    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex < 0) {
            return ans;
        }
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(0, 1);
            for (int j = 1; j < ans.size() - 1; j ++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));
	}
}
