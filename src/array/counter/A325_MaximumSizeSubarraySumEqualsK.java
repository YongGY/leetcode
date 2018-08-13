package array.counter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up:
 * Can you do it in O(n) time?
 * 
 * 
 * 
 * Solution Explanation
 * This problem is very similar to rest of the subarray sum problems. 
 * The initial intution is to find the sum of all numbers at every index i, if it matches with 'K',
 * store the index in max, keep updating it if and when there is a new index whose sum equals to K.
 * 
 * It works great, but until you realize that there may be an 'i' greater than zero, and another index 'j' where,
 * 
 *    sum(j) - sum(i) = K
 *    
 * To find a potential value like this, we can store the values in a map and retrieve, every time when the above condition matches.
 * 
 * 
 * Time Complexity
 * We traverse through the whole array once and caclulate sum and max index, so the time complexity is O(n), space complexity is O(n) since we use a map.
 * @author William
 *
 * https://zhuanlan.zhihu.com/p/32854569
 * 先求出每个位置的从index = 0加到此位置的和，这时（和i - 和j） 就是j~i之间的subarray的和，
 * 因此，我们用hashmap的方法来检测target-sum1=sum2中的sum2是否存在，当遍历到sum1的时候，思路类似于two sum的hashmap方法。
 * 
 * 用哈希表可以巧妙降低时间复杂度，思路优点像two sum这一问题。
 * 我们定义一个哈希表，使得hash[sum] == i表示[0,i]区间内的数字和是sum。
 * 这样在遍历数组中的数字的时候，假设累积和是sum，一旦发现（sum - k）已经在哈希表中出现，则说明区间[hash[sum - k], i]的和就是k，此时就可以更新返回值的大小。
 * 当然在遍历的同时也需要检查hash[sum]是否存在，如果不存在，就需要添加（但是如果已经存在，则不需要更新，请思考为什么^_^）。
 * 该算法的时间复杂度和空间复杂度都是O(n)。
 *
 */
public class A325_MaximumSizeSubarraySumEqualsK {
	
	public static int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (sum == k) {
				max = i + 1;
			}else if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		System.out.println(map);
		return max;
	}

	public static void main(String[] args) {
//		System.out.println(maxSubArrayLen(new int[] {-2, -1, 2, 1}, 3));
//		System.out.println(maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3));
		System.out.println(maxSubArrayLen(new int[] {2,0,2,1,1,1}, 3));
//		System.out.println(maxSubArrayLen(new int[] {1, 2, -3, 3, -1, 2, 4}, 3));
	}
}
