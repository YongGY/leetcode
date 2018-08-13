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
 * http://fisherlei.blogspot.com/2015/10/leetcode-product-of-array-except-self.html
 *
 * https://github.com/nekocode/leetcode-solutions/blob/master/solutions/238.%20Product%20of%20Array%20Except%20Self.md
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
		if(nums == null || nums.length == 0){
			return new int[]{};
		}
		int len = nums.length;
		int [] res = new int[len];
		res[0] = 1;

		int l = 1;
		for(int i = 0; i < len - 1; i++){
			l *= nums[i];
			res[i + 1] = l;
		}

		int r = 1;
		for(int i = len - 1; i > 0; i--){
			r *= nums[i];
			res[i - 1] *= r;
		}
		return res;
	}
	
	
	
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
 	}
}
