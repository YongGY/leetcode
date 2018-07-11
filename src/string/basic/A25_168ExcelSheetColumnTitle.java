package string.basic;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *     ...
 * Example 1:
 * Input: 1
 * Output: "A"
 * 
 * Example 2:
 * Input: 28
 * Output: "AB"
 * 
 * Example 3:
 * Input: 701
 * Output: "ZY"
 * 
 * 
 * @author William
 *
 */
public class A25_168ExcelSheetColumnTitle {
	
	public static String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char) (n % 26 + 'A'));
			n = n / 26;
		}
		return sb.reverse().toString();
	}
	
	
	
 	public static void main(String[] args) {
 		// AA = A( 1 * 26) + A = 27
 		// AB = A( 1 * 26) + B = 28
 		// ZY = Z(26 * 26) + 25 = 701
		System.out.println(convertToTitle(27));
	}
}
