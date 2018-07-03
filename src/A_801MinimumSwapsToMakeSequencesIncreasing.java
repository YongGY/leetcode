
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
 
 * Now, if A[i-1] < A[i] and B[i-1] < B[i], then it is allowed to have both of these columns natural (unswapped), or both of these columns swapped. 
 * This possibility leads to n2 = min(n2, n1) and s2 = min(s2, s1 + 1).
 * 
 * Another, (not exclusive) possibility is that A[i-1] < B[i] and B[i-1] < A[i]. This means that it is allowed to have exactly one of these columns swapped. 
 * This possibility leads to n2 = min(n2, s1) or s2 = min(s2, n1 + 1).
 * 
 * Note that it is important to use two if statements separately, because both of the above possibilities might be possible.
 * At the end, the optimal solution must leave the last column either natural or swapped, so we take the minimum number of swaps between the two possibilities.
 * 
 * First we can consider dynamic programming algorithm 
 * because the question is the arrays are strictly increasing,this means there is a relationship between A[i-1] and A[i], so we choose dp
 * 
 * For dp we just focus on A[i-1] and A[i] find the f
 * 
 */
public class A_801MinimumSwapsToMakeSequencesIncreasing {
	public static int minSwap(int[] A, int[] B) {
		int len = A.length;
	    int n1 = 0; //  ni代示  n(i-1) 不需要交换就已经是有序的了
	    int s1 = 1; //  si代表  s(i-1) 在i - 1处交换一次就有序了
		
		for (int i = 1; i < len; ++i) {
			int n2 = len, s2 = len;
			if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
				n2 = Math.min(n2, n1); 		// no swap for both i-1 , i
				s2 = Math.min(s2, s1 + 1);	// swap for both i-1 , i
			}
			if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
				n2 = Math.min(n2, s1);		//swap i
				s2 = Math.min(s2, n1 + 1);	//swap i - 1
			}
			n1 = n2;
			s1 = s2;
		}
		return Math.min(n1, s1);
	}
	

		
	
	public static void main(String[] args) {
		System.out.println(minSwap(new int[] {1,3,5,4}, new int[] {1,2,3,7}));
	}
}
