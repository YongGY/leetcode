package a4_tree.level;

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

	/**
	 * 对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有
	 *
	 * 		所有的非空节点提供2个出度和1个入度（根除外）
	 * 		所有的空节点但提供0个出度和1个入度
	 *
	 * 我们在遍历的时候，计算diff = outdegree – indegree.
	 * 当一个节点出现的时候，diff – 1，因为它提供一个入度；
	 * 当节点不是#的时候，diff+2(提供两个出度) 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0.
	 */


	/**
	 * 非叶子结点，入度是1，出度是2；
	 *
	 * 叶子节点，入度是1，出度是0；
	 *
	 * 所以计算diff表示总的（入度-出度），初始化1;
	 *
	 * 主要过程中，出现diff<0表示出错，结束后diff==0才可以;
	 */

	class Solution {//9ms
		public boolean isValidSerialization(String preorder) {
			String[] ptr = preorder.split(",");
			int degree = -1;//根节点没有入度，初始化为-1
			for (String p : ptr){
				degree ++;//除根节点外，其余节点入度均为1
				if (degree > 0){//总的度不能大于0
					return false;
				}
				if(! p.equals("#")){//非叶节点的出度为2
					degree -= 2;
				}
			}
			return degree == 0;
		}
	}


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
