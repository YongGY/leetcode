package a1_array.basic;

/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 * 
 * @author William
 *
 */
public class A045_JumpGameII {
        /**
         * times就是跳了多少次
         * reached就是当前跳了times次时能到的最远范围(表示当前步数下最远能走到哪里)
         * max是路过的位置之处再跳一次能到达的最远的位置
         *
         * 总之就是用了贪心的策略，reached和times表示跳了times次后，某一段区间内最小的步伐到达数量
         *
         * 而max则记录了路过的所有节点的，再跳一次能有多远，这个可以用来更新reached
         *
         * */
        public static int jump(int[] nums) {
            int times = 0;
            int reached = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (reached < i) {
                    times++;
                    reached = max;
                }
                max = Math.max(max, i + nums[i]);
            }
            return times;
        }
        
        
        public static void main(String[] args) {
            System.out.println(jump(new int[]{2,3,1,1,4}));
        }
}
