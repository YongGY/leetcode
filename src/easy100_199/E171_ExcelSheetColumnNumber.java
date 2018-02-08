package easy100_199;


/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 
 * B -> 2 
 * C -> 3 
 * ... 
 * Z -> 26 
 * AA -> 27 
 * AB -> 28
 * 
 */

public class E171_ExcelSheetColumnNumber {

	public static int titleToNumber(String s) {
		int num = 0;
		int pow = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			num += (s.charAt(i) - 'A' + 1) * pow;
			pow = pow * 26;
		}
		return num;
	}

	public static void main(String[] args) {

		System.out.println();

		System.out.println(titleToNumber("A"));
	}

}
