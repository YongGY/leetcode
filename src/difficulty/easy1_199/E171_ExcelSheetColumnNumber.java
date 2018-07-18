package difficulty.easy1_199;


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
        int result = 0;
        for (char letter : s.toCharArray()) {
            result = result * 26 + letter - 'A' + 1;
        }
        return result;
    }
 
	
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("ABA"));
	}

}
