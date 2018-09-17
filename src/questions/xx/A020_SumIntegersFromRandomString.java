package questions.xx;

public class A020_SumIntegersFromRandomString {

	/**
	 *  Write java program to sum of all integers from a random String
	 * "1a2b3c" => 6 (1+2+3)
	 * 
	 * "123ab!45c" => 168 (123+45)
	 * 
	 * "abcdef" => 0 (no Integers in String)
	 * 
	 * "0123.4" => 127 (0123+4)
	 * 
	 * "dFD$#23+++12@#T1234;/.,10" => 1279 (23+12+1234+10)
	 * 
	 * "dFD$#23+++12@#T1234;/.,10" => 1279 (23+12+1234+10)
	 * 
	 * "12a-10b"=>2
	 * 
	 * "12a-b10"=>22
	 * 
	 */
	public static int countString(String input) {
		int sum = 0;
		int temp = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				temp = temp * 10 + (c - '0');
			} else {
				sum = sum + temp;
				temp = 0;
			}
		}
		if (temp != 0) {
			sum = sum + temp;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(countString("1a2b3c"));
		System.out.println(countString("123ab!45c"));
		System.out.println(countString("abcdef"));
		System.out.println(countString("0123.4"));
		System.out.println(countString("dFD$#23+++12@#T1234;/.,10"));
		System.out.println(countString("12a-10b"));
	}
}
