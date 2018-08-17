package a1_array.basic;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space
 * 
 * @author William
 *
 */
public class A164_MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int len = nums.length;

        if (len == 2) {
            return Math.abs(nums[0] - nums[1]);
        }

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        // 每个桶的长度len,向上取整所以加+
        int gap = (max - min) / (len - 1);
        gap = gap == 0 ? 1 : gap;

        //桶的个数:(maxNum - minNum) / len + 1,每个桶里面存储属于该桶的最大值和最小值即可，注意这里的最大最小值是局部的
        int leng = (max - min) / gap + 1;
        int[] bucketMax = new int[leng];
        int[] bucketMin = new int[leng];

        for (int i = 0; i < len; i++) {
            int index = (nums[i] - min) / gap;
            if (nums[i] > bucketMax[index]) {
                bucketMax[index] = nums[i];
            }
            if (bucketMin[index] == 0 || nums[i] < bucketMin[index]) {
                bucketMin[index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(bucketMax));
        System.out.println(Arrays.toString(bucketMin));
        int myMax = 0;
        for (int i = 0; i < leng; i++) {
            if (myMax < bucketMin[i] - min) {
                myMax = bucketMin[i] - min;
            }
            if (bucketMax [i] != 0) {
                min = bucketMax [i];
            }
        }
        return myMax;
    }
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81}));
//        System.out.println(maximumGap(new int[]{3,6,9,1}));
     }

}
