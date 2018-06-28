package easy1_199;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * 
 * @author William
 *
 */
public class E069_Sqrt_x {

	public static int mySqrt(int x) {
		long i = 0;
		long j = x / 2 + 1;
		while (i <= j) {
			long mid = (i + j) / 2;
			if(mid * mid == x) {
				return (int)mid;
			}
			if (mid * mid < x) {
				i = mid + 1;
			} else {
				j = mid - 1;
			} 
		}
		return (int) j;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int mySqrt1(int x) {
		
		int i = 0;
		int j = x / 2 +1;
		while(i <= j) {
			int mid = (i + j) / 2;
			if(mid * mid == x)  return mid;
			if(mid * mid < x) {
				i = mid +1;
			}else {
				j = mid - 1;
			}
		}
		
		return (int)j;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(10));
	}

}
