package a3_math.seldom;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 * Example 2:
 * Input: 0
 * Output: false
 *
 * Example 3:
 * Input: 9
 * Output: true
 *
 * Example 4:
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 * 
 * @author William
 *
 */
public class A326_PowerOfThree {

	//思路一：循环除以三。
	public boolean isPowerOfThree(int n) {
		if(n<=0 || n==2) return false;
		while(n%3==0){
			n /= 3;
		}
		return n==1;
	}


	public boolean isPowerOfThree1(int n) {
		 return (n>0 && 1162261467%n==0);
	}
	
	public boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3) % 1 == 0);    
	}

 	public static void main(String[] args) {

	}
}
