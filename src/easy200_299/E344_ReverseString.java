package easy200_299;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 */

public class E344_ReverseString {

    public static String reverseString(String s) {
    	StringBuffer stringBuffer = new StringBuffer();
    	for (int i = s.length()- 1 ; i >= 0 ; i--) {
    		stringBuffer.append(s.charAt(i));
		}
		return stringBuffer.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}
}
