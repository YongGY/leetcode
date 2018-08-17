package a2_string.basic;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *       A -> 1
 *       B -> 2
 *       C -> 3
 *       ...
 *       Z -> 26
 *       AA -> 27
 *       AB -> 28 
 *       ...
 * Example 1:
 * Input: "A"
 * Output: 1
 * 
 * Example 2:
 * Input: "AB"
 * Output: 28
 * 
 * Example 3:
 * Input: "ZY"
 * Output: 701
 * 
 * @author William
 *
 */
public class A26_171ExcelSheetColumnNumber {
		// AA = A( 1 * 26) + A = 27
		// AB = A( 1 * 26) + B = 28
		// ZY = Z(26 * 26) + 25 = 701
		// ZZA = Z(26 * 26) + 25 = 701
    public static int titleToNumber(String s) {
        int result = 0;
        for (char letter : s.toCharArray()) {
        	System.out.println(result  + "   "+(result * 26) + "  "+(letter - 'A' + 1) );
            result = result * 26 + letter - 'A' + 1;
        }
        return result;
    }
	
	
 	public static void main(String[] args) {
		System.out.println(titleToNumber("ZZA"));
	}
}
