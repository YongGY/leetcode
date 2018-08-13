package array.sort;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. 
 * The first difference (if one exists) may be either positive or negative. 
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, 
 * the first because its first two differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
 * leaving the remaining elements in their original order.
 * 
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * Follow up:
 * Can you do it in O(n) time?
 * 
 * @author William
 *
 */
public class A376_WiggleSubsequence {

    /**
     * https://blog.csdn.net/Johnsonjjj/article/details/78389482
     *
     */
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int posTemp = 1;
        int negTemp = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                posTemp = negTemp + 1;
            }else if(nums[i] < nums[i - 1]){
                negTemp = posTemp + 1;
            }
        }
		return Math.max(posTemp, negTemp);
    }

    public static int wiggleMaxLength1(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        int pdiff = nums[1] - nums[0];
        int count = pdiff == 0 ? 1 : 2;
        for(int i = 2; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if( (diff < 0 && pdiff >= 0 ) || (diff > 0 && pdiff <=0 )){
                count++;
                pdiff = diff;
            }
        }
        return count;
    }




        public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLength1(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
