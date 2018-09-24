package test;

public class W022_SumIntegersFromString {

	/**
	 * 22.Given a string, find sum up all the integers’ inside. 
	 * 
	 * For example:
	 * "1abcd45" return 1+45 =46; 
	 * "233bc-23" return 233 + 23 = 256; 
	 * 
	 * if allow negative number, 
	 * "233bc-23" return 233 - 23 = 210;
	 * 
	 */
	public static int countString(String input, boolean isAllowNegative) {
		int sum = 0;
		int temp = 0;
		int tnum = 1;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				if (isAllowNegative && temp == 0 && i > 0 && input.charAt(i - 1) == '-') {
					tnum = -1;
				}
				temp = temp * 10 + (c - '0');
			} else {
				sum = sum + temp * tnum;
				temp = 0;
				tnum = 1;
			}
		}
		if (temp != 0) {
			sum = sum + temp * tnum;
		}
		return sum;
	}

	public static void main(String[] args) {
//		System.out.println(countString("1a2b3c",false));
//		System.out.println(countString("123ab!45c",false));
//		System.out.println(countString("abcdef",false));
//		System.out.println(countString("0123.4",false));
//		System.out.println(countString("dFD$#23+++12@#T1234;/.,10",false));
		//System.out.println(countString("12a-10b",true));
		System.out.println(countString("-233bc-23",false));
	}
}
