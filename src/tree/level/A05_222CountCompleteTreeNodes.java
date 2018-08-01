package tree.level;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * 
 * @author William
 *
 */
public class A05_222CountCompleteTreeNodes {
	
    
 	public static void main(String[] args) {
		int leftShift = 10;
		System.out.println("十进制:" + leftShift + ", 二进制:" + Integer.toBinaryString(leftShift));
		int newLeftShift = leftShift << 2;
		System.out.println("左移2位后十进制:" + newLeftShift + ", 左移2位后二进制" + Integer.toBinaryString(newLeftShift)); //正整数x左移n位后的十进制结果，x = x * 2^n

		int rightShift = 10;
		System.out.println("十进制:" + rightShift + ", 二进制:" + Integer.toBinaryString(rightShift));
		int newRightShift = rightShift >> 2;
		System.out.println("右移2位后十进制:" + newRightShift + ", 右移2位后二进制" + Integer.toBinaryString(newRightShift));  //右移n位后的运算数x十进制结果，x = x / 2


	}
}
