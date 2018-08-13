package string.basic;

/**
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * 
 * Example 1:
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * Example 2:
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * Example 4:
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 
 * @author William
 * 
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 * 
 * Test:
 * 0
 * 1000
 * 1000010
 * 
 * 注意: i++的位置；最后结果要trim().
 *
 */
public class A29_273IntegerToEnglishWords {
	
	private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		
		int i = 0;
		String res = "";
		while (num > 0) {
			if (num % 1000 != 0) { // 3 digits a group
				res = helper(num % 1000) + THOUSANDS[i] + " " + res;
			}
			num /= 1000;
			i++; // cannot put into THOUSANDS[i++] !!! e.x. 1000
		}
		return res.trim(); // important
	}

	private static String helper(int num) {
		if (num == 0)
			return ""; // necessary! 50868
		else if (num < 20)
			return LESS_THAN_20[num] + " "; // 1 - 19
		else if (num < 100)
			return TENS[num / 10] + " " + helper(num % 10); // 20,30,40,50,60,70,80,90
		else
			return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100); // > 100
	}
 
 	public static void main(String[] args) {
		System.out.println(1 % 3);
		System.out.println(numberToWords(1001));
	}
}
