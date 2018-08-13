package string.palindrome;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author William
 *
 */
public class A08_132PalindromePartitioningII {

	/**
	 * 题解：
	 *
	 * 一上来思路是在Palindrome Partition I的基础上，找到所有的Partition，然后再查找一遍最短的解，这样做会超时。
	 * 接下来又想可不可以使用suffix array / suffix tree，或者Manancher。
	 * 最后想来想去老老实实看discuss去。大部分还是使用dp - 初始化，找到转移方程，然后计算。
	 *
	 * 初始定义一个一维数组minCuts，用来表示s.substring(0, i + 1)时的最小cut数。
	 *
	 * 再定义一个二维布尔数组isPalindrome，用来表示 s.substring(j, i)是否是palindrome。
	 *
	 * 核心算法是:
	 *
	 * 假如isPalindrome[j][i]是palindrome，说明 j - 1至i + 1只需要1个cut，
	 * 因此对每一个i， minCuts[i]可以进行更新 - 比较现有 minCuts[i] 与 minCuts[j - 1] + 1。
	 * 这里也是一个一维的dp。
	 *
	 *
	 * 而另外一部分，isPalindrome[j][i]是palindrome的条件是 isPalindrome[j + 1，i - 1]为true而且s.charAt(j) == s.charAt(i)。
	 * 举个例子，字符串"abba"， j = s.charAt(0)， i = s.charAt(3)， 则"abba"为true的条件是"bb"为palindrome而且'a' == 'a'。
	 * 其中 j + 1 = s.charAt(1), i - 1 = s.charAt(2)。即 j + 1, i - 1代表当前字符串内部1个单位的子串。
	 *
	 * 特殊情况是 i - j <= 1时，isPalindrome[j，i]也为true。
	 * 因为 i - j = 0时，i = j， 此时s.substring(j，i)是一个字符，所以为true。
	 * 而i - j = 1时，类似于“bb”, 此时是偶数Palindrome，所以值也为true。
	 * （其实情况可以扩大到i - j <= 2， 这时 s.charAt(i) == s.charAt(j)，
	 * 类似于"aba"，可以忽略中间的字符，也是一个Palindrome，不过对结果没有影响， 因为这种情况会被 i - j = 0 包括)
	 *
	 * 对每个i来说， 一开始可以初始化minCuts[i] = Integer.MAX_VALUE，或者 minCuts[i] = i。
	 * 每次判断到isPalindrome[j][i]为真时，尝试更新 minCuts[i]。
	 * 这里的特殊情况是，当j = 0时， 说明 0 至 i + 1为palindrome，此时不需要cut，所以设置 minCuts[i] = 0。
	 *
	 * Time Complexity - O(n2)， Space Complexity - O(n2)。
	 */
	public int minCut(String s) {
		int len = s.length();
		// cut[j]表示子串s[0,j]所需要的最小分割数
		int[] minCuts = new int[len];  //minCuts[i] is min cut for s.substring(0, i + 1)

		boolean[][] isPalindrome = new boolean[len][len];  // isPal[i][j]表示字符串s的子串s[i,j]是否为回文串

		for (int i = 0; i < len; i++) {
			minCuts[i] = Integer.MAX_VALUE;  //set initial value for minCuts[i]

			for (int j = 0; j <= i; j++) {  // 判断s[j,i]是否是回文串
				if (s.charAt(i) == s.charAt(j)) {   //if s.substring(j, i) is Palindrome
					if (i - j <= 1 || isPalindrome[j + 1][i - 1]) {
						isPalindrome[j][i] = true;
						if (j == 0) { // s[0,i]是回文串
							minCuts[i] = 0; //if(s[0....i] is palindrome),  no cut needed
						}
						else {
							minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);  //1-D dp
						}
					}
				}
			}
		}

		return minCuts[len - 1];
	}
    
 	public static void main(String[] args) {
 		
	}
}
