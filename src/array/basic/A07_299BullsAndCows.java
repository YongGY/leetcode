package array.basic;

import java.util.Arrays;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows.
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * Example 1:
 * Input: secret = "1807", guess = "7812"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * 
 * Example 2:
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * 
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * 
 * 有一个四位数字，你猜一个结果，然后根据你猜的结果和真实结果做对比，
 * 提示有多少个数字和位置都正确的叫做bulls，还提示有多少数字正确但位置不对的叫做cows，
 * 
 * A的意思是位置正确且数字正确的个数； 
 * B的意思是位置不正确但数字正确的个数。
 * 
 * 对于secret列每次读取相应的部分，如果与guess对应的部分相同，则bulls变量加一；否则，对于secret的部分相应字典的数值加一，guess对应的字典减一。
 * 再判断secret对应字典的数值是否小于等于0，若是则把bulls的变量加一（表明之前guess中已经出现该字符，且配对成功）
 * 判断guess对应字典的数值是否大于等于0，若是则把bulls的变量加一（表明之前secret中已经出现该字符，且配对成功）
 * 
 * 若是count[s - '0'] 小于0, 说明guess 已经更新过这个位置，此时numCow++. 
 * 若是count[g - '0'] 大于0, 说明secret 已经更新过这个位置， 此时numCow++.
 * 
 * @author Willam
 *
 */
public class A07_299BullsAndCows {
	public static String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] count = new int[10];
		for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
			if (s == g) {
				bulls++;
			} else {
				
//				猜字游戏 secret.charAt(i) == guess.charAt(i)时bull++.
//				用map来记录character 和出现的次数. secret扫过数字，mark对应count加一，guess扫过数字，mark对应count减一.
//				若是mark[secret.charAt(i) - '0'] 小于0, 说明guess 已经更新过这个位置，此时numCow++. 反过来若是 mark[guess.charAt(i) - '0'] 大于0, 说明secret 已经跟新过这个位置， 此时numCow++.
//				Time Complexity: O(n). 只需要扫一遍两个string. Space: O(1). 一个长度为10的array.
				
				//guess里有多余的，因为小于0只可能是guess造成的
				//secret里有多余的，因为大于0只可能是secret造成的
				if(count[s -'0']++ < 0 || count[g - '0']-- > 0) {
					cows++;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		return bulls + "A" + cows + "B";
	}
	
	public static void main(String[] args) {
//		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1234", "0155"));
	}
}