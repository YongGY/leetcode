package tree.test.bst;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 * 
 * @author William
 *
 * https://gist.github.com/BiruLyu/8d314ef55539176646476da3c7d3309c
 */
public class A08_297SerializeandDeserializeBinaryTree {

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {

		}



		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {

		}

 	}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

	public static void main(String[] args) {
		Codec c = new A08_297SerializeandDeserializeBinaryTree().new Codec();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;

		t3.left = t4;
		t3.right = t5;
		String se = c.serialize(t1);
		System.out.println(se);

		TreeNode n = c.deserialize(se);
		System.out.println(n);
	}
}
