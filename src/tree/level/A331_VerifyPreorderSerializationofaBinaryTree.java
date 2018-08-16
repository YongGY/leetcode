package tree.level;

import java.util.LinkedList;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 * Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * Example 1:
 *
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 *
 * Input: "1,#"
 * Output: false
 * Example 3:
 *
 * Input: "9,#,#,1"
 * Output: false
 * 
 * @author William
 *
 */
public class A331_VerifyPreorderSerializationofaBinaryTree {

// https://hzhou.me/LeetCode/
//	如果我们利用栈的方法来解决，我们可以从左到右对字符串进行扫描。
//  如果我们看到一个数字，将其入栈；如果看到#号，检查栈顶是否也为#号，如果是，一直做pop操作直到栈顶不是#号，如果不是，则将#号入栈。扫描完后检查栈的大小为1且栈顶为#即可。
//
//	我们还可以用图的出度入度来解决。

	public boolean isValidSerialization(String preorder) {
		String[] array = preorder.split(",");
		//The in-degree of root is 0, out-degree is 2. Compansation.
		int count = -1;
		for (int i = 0; i < array.length; i++) {
			count++;
			if (count > 0) {
				return false;
			}
			//Positive for in-degree, negative for out-degree.
			//Normal node: in-degree:1, out-degree:2
			if (!array[i].equals("#")) {
				count = count - 2;
			}
		}
		return count == 0;
	}

	//https://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
	public boolean isValidSerialization1(String preorder) {
		LinkedList<String> stack = new LinkedList<String>();
		String[] arr = preorder.split(",");

		for (int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);

			while (stack.size() >= 3
					&& stack.get(stack.size() - 1).equals("#")
					&& stack.get(stack.size() - 2).equals("#")
					&& !stack.get(stack.size() - 3).equals("#")) {

				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);
				stack.remove(stack.size() - 1);

				stack.add("#");
			}
		}

		if (stack.size() == 1 && stack.get(0).equals("#"))
			return true;
		else
			return false;
	}

 	public static void main(String[] args) {
 		
	}
}
