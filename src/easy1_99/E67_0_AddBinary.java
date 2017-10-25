package easy1_99;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author William
 *
 */
public class E67_0_AddBinary {

	public static String addBinary(String a, String b) {

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i >= 0 || j >= 0) {
			int m = i >= 0 ? a.charAt(i) - '0' : 0;
			int n = j >= 0 ? b.charAt(j) - '0' : 0;
			System.out.println(m +"=========="+ n);
			int sum = m + n + carry;
			carry = sum / 2;
			System.out.println("sum="+ sum   + "    carry=" + carry);
			sb.insert(0, String.valueOf(sum % 2));
			i--;
			j--;
		}
		
		if (carry != 0) {
			sb.insert(0, '1');
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
		
	}

}
