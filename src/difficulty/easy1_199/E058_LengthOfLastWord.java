package difficulty.easy1_199;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author William
 *
 */
public class E058_LengthOfLastWord {

    public static int lengthOfLastWord01(String s) {
    	String[] a = s.split(" ");
    	if(a == null || a.length == 0) {
        	return 0;
    	}
    	return a[a.length-1].length();
    }
	
    public static int lengthOfLastWord(String s) {
    	int result = 0, i = s.length() - 1;
    	while(i > 0 && s.charAt(i) == ' '){
    		i--;
    	}
    	System.out.println(i+"=======");
    	while(i > 0 && s.charAt(i) != ' '){
    		i--;
    		result ++ ;
    	}
		return result;
    }
    
    
    public static int lengthOfLastWord2(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (chars[i] == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (chars[i] == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }

        return length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("Hello World aeiou"));
	}

}
