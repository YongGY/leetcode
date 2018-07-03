
/**
 * We have two integer sequences A and B of the same non-zero length.
 * 
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 * 
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 * 
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 * 
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7] 
 * Output: 1
 * 
 * Explanation: 
 * Swap A[3] and B[3].  Then the sequences are: A = [1, 3, 5, 7] and B = [1, 2, 3, 4] which are both strictly increasing.
 * 
 * Note:
 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
 * A[i], B[i] are integer values in the range [0, 2000].
 * 
 * @author William
 *
 * 对位交换A[i]和B[i]交换,怎么利用最少的次数交换可以让A数组和B数组严格递增(也就是A[i] > A[i - 1], i >= 1).题目是保证有可行答案的.
 * 
 * 1. A[i] > A[i -1] && B[i] > B[i - 1],
 * if we choose to keep, we should keep the previous i - 1 elements. So keep[i] = keep[i - 1]
 * If we choose to swap, in order to maintain the sequencing order, we must swap the previous i - 1 th element. So swap[i] = swap[i - 1] + 1;

 * 2. A[i] > B[i - 1] && B[i] > A[i - 1]
 * If we choose to keep, keep[i] = Math.min(keep[i], swap[i - 1])
 * If we choose to swap, swap[i] = Math.min(swap[i], keep[i - 1] + 1)
 * 
 * 3. For other cases such as A[i] < B[i - 1] we don't need to consider since we gurantee there will be a solution.
 * 
 * 
 * 
 * For convenience, say
 * 						a1 = A[i-1], 	b1 = B[i-1] and 
 * 						a2 = A[i], 		b2 = B[i].
 * 
 * Now, if a1 < a2 and b1 < b2, then it is allowed to have both of these columns natural (unswapped), or both of these columns swapped. 
 * This possibility leads to n2 = min(n2, n1) and s2 = min(s2, s1 + 1).
 * Another, (not exclusive) possibility is that a1 < b2 and b1 < a2. This means that it is allowed to have exactly one of these columns swapped. This possibility leads to n2 = min(n2, s1) or s2 = min(s2, n1 + 1).
 * Note that it is important to use two if statements separately, because both of the above possibilities might be possible.
 * At the end, the optimal solution must leave the last column either natural or swapped, so we take the minimum number of swaps between the two possibilities.
 * http://programmingchangheartbear.blogspot.com/2018/03/801-minimum-swaps-to-make-sequences.html
 */
public class A_801MinimumSwapsToMakeSequencesIncreasing {
	public static int minSwap(int[] A, int[] B) {
	    int n1 = 0; //  ni代示  n(i-1) 不需要交换就已经是有序的了
	    int s1 = 1; //  si代表  s(i-1) 在i - 1处交换一次就有序了
	    // 那么 以上推测， n1 = 0 s1 = 1 很明显，index 0处肯定是有序的
	    // index o 处 交换一次肯定也是有序的， 因为他们是第一个元素嘛
		
		// n: natural, s: swapped  swap和natural分别记录A[i]与B[i]交换或者不交换时的最小代价
//		int n1 = 0, s1 = 1;
		for (int i = 1; i < A.length; ++i) {
			int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
			if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
				n2 = Math.min(n2, n1);
				s2 = Math.min(s2, s1 + 1);
			}
			if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
				n2 = Math.min(n2, s1);
				s2 = Math.min(s2, n1 + 1);
			}
			n1 = n2;
			s1 = s2;
		}
		return Math.min(n1, s1);
	}

	/**
	 * 我们假定n1是 n-1处，没有交换就有序的花费,s1是n-1处交换之后的花费，我们现在要依靠 n1,s1来推测 n2, s2的花费。 
	 * 我们可以假设，a1 = A[i-1], b1 = B[i-1] || a2 = A[i], b2 = B[i]. 
	 * 如果 a1 < a2 && b1 < b2 很显然，n2 = min(n1,n2),s2 = min(s2, s1 + 1), 
	 * 因为 s2 总是代表交换之后的花费。 
	 * a1 < b2 && b1 < a2 n2 = min(n2,s1),s2 = min(s2, n1 + 1), 
	 * 
	 * 写出算法如下：
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minSwap(new int[] {1,3,5,4}, new int[] {1,2,3,7}));
	}
}
