package difficulty.medium1_99;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N 
 * A P L S I I G 
 * Y   I   R 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 
 * 
 * 三层的如果想要组成一个V那就需要4个字母，（3*2-2=4）
 * 四层的如果想要组成一个V那就需要6个字母，（4*2-2=6）
 * 五层的如果想要组成一个V那就需要8个字母，（5*2-2=8）
 * 以此类推，6层需要10个，7层需要12个
 * @author William
 *
 */
public class M06_ZigZagConversion {
	
	public String convert(String s, int numRows) {
		if (numRows == 0) {
			return null;
		}
		if (numRows == 1 || s.length() == 1) {
			return s;
		}

		String result = "";
		int oneZigzagSize = numRows * 2 - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += oneZigzagSize) {
				result += s.charAt(j);
				if (i != 0 && i != numRows - 1 && j + oneZigzagSize - 2 * i < s.length()) {// numRows - i - 1 + numRows
					result += s.charAt(j + oneZigzagSize - 2 * i);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
