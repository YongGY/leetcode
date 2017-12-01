package easy100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author William
 * 
 * 除每行最左側與最右側的數字以外，每个数字等于它的左上方與右上方两个数字之和
 * 
 */
public class E119_PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> line = new ArrayList<Integer>();
        // 加入第一个1
        line.add(1);
        if(rowIndex <= 0) return line;
        for(int i = 1; i <= rowIndex; i++){
            // 计算j+1位置的值，是根据j位置的值和j+1位置的值得到的，相当于往后位移一位
            for(int j = line.size() - 2; j >= 0; j--){
                line.set(j + 1, line.get(j) + line.get(j + 1));
            }
            // 加上最后一个1
            line.add(1);
        }
		return line;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));
	}

}
