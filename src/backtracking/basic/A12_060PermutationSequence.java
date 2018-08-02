package backtracking.basic;

import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * @author William
 *
 */
public class A12_060PermutationSequence {

	/**
	 * 我们主要是使用以下几个步骤:
	 *
	 * 		1.先求得[1, n]的factorial， 同时创建一个linkedlist，node分别为[1, n]
	 *
	 * 		2.k--， 将k从 1-based转换为0-based，方便以后我们的模操作。
	 *
	 * 		3.这里可以加一步判断，假如k >= n那么我们返回一个特定的字符串。
	 *
	 * 		4.在n > 0的时候
	 * 			1.我们先把factorial减少到(n - 1)!
	 * 			2.然后我们计算k 中有多少个(n - 1)!，把这个数字作为linkedlist中的index找到相应的节点，删除这个节点并且将其值加到sb中
	 * 			3.使用 k % factorial将 k映射到 (n - 1)！的范围内
	 * 			4.n--， 继续下一次操作。
	 *
	 * 		5.返回结果sb.toString();
	 *
	 * Time Complexity - O(n)， Space Complexity - O(n)。
	 * 其实因为n只在1 ~ 9中，所以我们可以假定时空间复杂度都是O(1)
	 */


	// https://www.tianmaying.com/tutorial/LC60
	public String getPermutation(int n, int k) {
		if (k <= 0 || n <= 0) {
			return "";
		}
		List<Integer> nums = new LinkedList<>();
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
			nums.add(i);
		}
		StringBuilder sb = new StringBuilder();
		k--;
		while (n > 0) {
			factorial /= n;
			sb.append(nums.remove(k / factorial));
			k %= factorial;
			n--;
		}
		return sb.toString();
	}
    
 	public static void main(String[] args) {
 		
	}
}
