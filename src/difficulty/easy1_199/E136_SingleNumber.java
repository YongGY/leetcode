package difficulty.easy1_199;


/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author William
 * 
 *         这道题运用位运算的异或。异或是相同为0，不同为1。所以对所有数进行异或，得出的那个数就是single
 *         number。初始时先让一个数与0异或，然后再对剩下读数挨个进行异或。
 * 
 *         这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x
 * 
 *         同时异或还有性质：
 * 
 *         交换律 A XOR B = B XOR A
 * 
 *         结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
 * 
 *         自反性 A XOR B XOR B = A XOR 0 = A
 *         
 *         所以对于这个数组来说，因为只有一个数字是single的，所以数组可以表示为 a a b b c c d d e。 那么利用上述规律可以异或结果为 0 0 0 0 e。这样写的代码为：
 *         
 *         https://www.cnblogs.com/springfor/p/3870801.html
 * 
 */
public class E136_SingleNumber {

	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
			System.out.println(result);

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[] { 1, 2, 1 }));
	}
}
