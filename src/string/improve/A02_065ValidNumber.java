package string.improve;

/**
 * 
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 	"0" => true
 * 	" 0.1 " => true
 * 	"abc" => false
 * 	"1 a" => false
 * 	"2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * 
 * @author William
 *
 * 
 */
public class A02_065ValidNumber {
	
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.isEmpty())
			return false;
		boolean isNumber = false, isExponent = false, isPoint = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'e' || c == 'E') {
				if (!isNumber || isExponent) {
					return false;
				}
				isNumber = false; // Should be: 2e2 , so there should be number follow "e"
				isExponent = true;
			} else if (c == '.') {
				if (isPoint || isExponent) { // can't be: e0.2 can't be: ..
					return false;
				}
				isPoint = true;
			} else if (c >= '0' && c <= '9') {
				isNumber = true;
			} else if (c == '+' || c == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') { // filter : " 005047e+6", this is true.
					return false;
				}
			} else { // invalid character.
				return false;
			}
		}
		return isNumber;
	}
 	public static void main(String[] args) {
 		
	}
}
