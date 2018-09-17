package questions.xx;

public class A024_PalindromeCheck {

	// My Method to check
	public static boolean isPal(String s) { // if length is 0 or 1 then String
											// is palindrome
		if (s.length() == 0 || s.length() == 1){
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1))
			/*
			 * check for first and last char of String: if they are same then do
			 * the same thing for a substring with first and last char removed.
			 * and carry on this until you string completes or condition fails
			 * Function calling itself: Recursion
			 */
			return isPal(s.substring(1, s.length() - 1));

		/*
		 * If program control reaches to this statement it means the String is
		 * not palindrome hence return false.
		 */
		return false;
	}
	
	
	public static boolean isPal2(String s) {
		if (s.length() == 0 || s.length() == 1){
			return true;
		}
		
		int left = 0;
		int right = s.length() - 1;
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}


	public static void main(String[] args) {
		String string = "12343211";
		if (isPal(string))
			System.out.println(string + " is a palindrome");
		else
			System.out.println(string + " is not a palindrome");
		
		if (isPal2(string))
			System.out.println(string + " is a palindrome");
		else
			System.out.println(string + " is not a palindrome");
	}
}