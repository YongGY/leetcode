package difficulty.medium1_99;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author William
 * 
 * 题解：
 * 这道题也是3sum的变体，这里找到的不仅使3sum==target，同时如果没有找到==target的3sum要返回最接近target的值。
 * 于是，这就需要在使用二分查找法时遍历数组的时候，维护一个最接近target值min，这样当完全遍历完数组扔没找到与target相等的3sum时，可以返回维护的这个min值。
 * 这道题比3sum和4sum简单的地方就是不需要判断重复问题，因为题目给我们减轻了去重的压力，have exactly one solution。
 * 即便要求去重，使用之前说过的两个方法：HashSet和挪动指针法，也可以很容易就去重了。
 * 这里要注意，判断closest的方法是采取target-sum的绝对值与min相比，很容易理解，无论这个closest是在target左还是右，离target最近的就是最closest的。
 *
 */
public class M16_3SumClosest {

	public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
		int bestSum = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
					bestSum = sum;
				}
				if (sum < target) {
					low++;
				} else {
					high--;
				}
			}
		}

		return bestSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( threeSumClosest(new int[] {-1, 2, 1, -4},2));
//		System.out.println( threeSumClosest(new int[] {-1, 0, 1, 2, -1, -4}));
	}

}
