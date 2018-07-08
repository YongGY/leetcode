package array.counter;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 * @author William
 * 
 * 我们以一个4个元素的数组为例，nums=[a1, a2, a3, a4]。 
 * 想在O(n)时间复杂度完成最终的数组输出，res=[a2*a3*a4, a1*a3*a4, a1*a2*a4, a2*a3*a4]。
 * 
 * 比较好的解决方法是构造两个数组相乘：
 * 
 * 		[1, 		a1, 	a1*a2, 	a1*a2*a3]
 * 		[a2*a3*a4, a3*a4, 	a4, 		1	]
 * 
 *
 */
public class A06_238ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
    	int [] pSep = new int[nums.length]; 
    	int [] nSep = new int[nums.length]; 
    	pSep[0] = 1;
    	for(int i=1;i<len;i++){
    		pSep[i] = pSep[i-1] * nums[i-1];
    	}
    	nSep[len - 1] = 1;
    	for(int i= len -2; i>=0; i--){
    		nSep[i] = nSep[i+1] * nums[i+1];
    	}
    	for(int i=0;i<len;i++){
    		pSep[i] = pSep[i] * nSep[i];
    	}
		return pSep;
    }
  
    
	public static  int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];

		result[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}

		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i];
		}
		return result;
	}
	
	
	
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    	System.out.println(Arrays.toString(productExceptSelf1(new int[]{1,2,3,4})));
 	}
}
