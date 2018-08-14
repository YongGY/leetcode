package string.parentheses;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * @author William
 *
 */
public class A032_LongestValidParentheses {

	/**
	 * 这道题是求最长的括号序列，比较容易想到用栈这个数据结构。
	 * 基本思路就是维护一个栈，遇到左括号就进栈，遇到右括号则出栈，并且判断当前合法序列是否为最长序列。
	 * 不过这道题看似思路简单，但是有许多比较刁钻的测试集。
	 * 具体来说，主要问题就是遇到右括号时如何判断当前的合法序列的长度。比较健壮的方式如下：
	 * (1) 如果当前栈为空，则说明加上当前右括号没有合法序列（有也是之前判断过的）；
	 * (2) 否则弹出栈顶元素，如果弹出后栈为空，则说明当前括号匹配，
	 * 	   我们会维护一个合法开始的起点start，合法序列的长度即为当前元素的位置-start+1；
	 * 	   否则如果栈内仍有元素，则当前合法序列的长度为当前栈顶元素的位置下一位到当前元素的距离，
	 * 	   因为栈顶元素后面的括号对肯定是合法的，而且左括号出过栈了。
	 *
	 * 因为只需要一遍扫描，算法的时间复杂度是O(n)，空间复杂度是栈的空间，最坏情况是都是左括号，所以是O(n)。实现的代码如下：
	 */

	// 使用栈，时间复杂度O(n)，空间复杂度O(n)
	public static int longestValidParentheses(String s) {
		// the position of the last ')'
		int maxLen = 0, last = -1;
		// keep track of the positions of non-matching '('s
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {  //等于左括号就把它的下标入堆
				stack.push(i);
			} else { //等于右括号
				if (stack.empty()) {
					// no matching left
					last = i;  //如果堆栈为空，说明当前的有括号无法配对，需要重新设置left的值
				} else {
					// find a matching pair
					stack.pop();  //如果有匹配的先弹出栈顶元素
					if (stack.empty()) {
						//如果弹出后的栈为空，则表明当前括号匹配，这时计算出当前的最长序列长度，
						// 即当前位置的值减去last即是
						maxLen = Math.max(maxLen, i - last);
					} else {
						////如果弹出后的栈内仍然有元素，则最长序列长度为当前元素位置减去栈顶元素的位置
						maxLen = Math.max(maxLen, i - stack.peek());
					}
				}
			}
		}
		return maxLen;
	}








	/**
	 * 对于括号匹配，和Valid Parentheses同样的思路，用栈维护左括号，即在读取字符串的时候，遇到左括号就入栈。
	 * 遇到右括号就出栈，同时判断当前括号匹配的子串是否为最长子串。
	 * 不过在判断括号匹配的子串的长度的时候，有一些值得注意的问题，其中需要借助变量l记录当前括号匹配的子串的左侧位置.
	 * 本题使用初始-1入栈，就省去了记录记录当前括号匹配的子串的左侧位置;（（））：3-(-1)=4;
	 * 但是栈为空的时候，需要入栈当前位置，例如 ())()()=6-2=4，在str[2]=‘）‘入栈index
	 */
	public int longestValidParentheses1(String s) {
		int len = 0;

		Stack<Integer> st = new Stack<>();

		st.push(-1);   //技巧使用了初始化，否则需要记录 需要借助变量l记录当前括号匹配的子串的左侧位置
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.empty()) {
					st.push(i);
				} else {
					len = Math.max(len, i - st.peek());
				}
			}
		}

		return len;
	}

 	public static void main(String[] args) {
 		System.out.println(longestValidParentheses("(()"));
 		System.out.println(longestValidParentheses(")()())"));
 		System.out.println(longestValidParentheses("(())"));
	}
}
