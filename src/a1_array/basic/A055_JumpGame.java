package a1_array.basic;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * 
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * 
 * 题目意思：有一个非负的数组，开始的位置在第一个索引上，数组里的每一个数字代表的意思是每一个位置所能跳跃的最大长度，看经过跳跃之后能否达到最后一个位置处。

 * 因为每个位置跳跃的长度加上此位置的索引是在这个位置跳跃后所能达到的索引位置，即nums[i]+i，为了判断是否能到达最后一个索引处，
 * 还需要用一个变量reach来判断reach与i的大小，reach是前面所有跳跃的最大索引处，如果当前索引大于reach，说明已经不能由前面的跳跃达到该索引。
 * @author William
 *
 */
public class A055_JumpGame {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int max = 0;      //记录到当前点时能到达的最大位置
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (max < i + 1) {     //如果到达不了后续点(这里通常情况为 当前点为0，前面的能达到的最大点 为当前点或者当前点前面的点)，返回false
                return false;
            }
            if (max >= (nums.length - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reach = 0;
        for (int i = 0; i <= reach; i++) {//只计算在能跳到的范围内的
            reach = Math.max(reach, i + nums[i]);
            if (reach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }
}
