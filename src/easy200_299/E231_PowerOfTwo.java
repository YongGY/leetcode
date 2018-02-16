package easy200_299;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */

 public class E231_PowerOfTwo {
	
	    public boolean isPowerOfTwo(int n) {
	    	if(n > 0 && (n & (n-1)) == 0 ) {
	    		return true;
	    	}
			return false;
	    }
}
