package array.basic;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
 * 
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * 
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author William
 *
 */
public class A33_287FindtheDuplicateNumber {


	/**
	 * 二分法
	 *
	 * 复杂度
	 * 时间 O(NlogN) 空间 O(1)
	 *
	 * 思路
	 * 我们可以用二分法先选取n/2，按照抽屉原理，整个数组中如果小于等于n/2的数的数量大于n/2，说明1到n/2这个区间是肯定有重复数字的。
	 *
	 * 比如6个抽屉，如果有7个袜子要放到抽屉里，那肯定有一个抽屉至少两个袜子。
	 * 这里抽屉就是1到n/2的每一个数，而袜子就是整个数组中小于等于n/2的那些数。
	 *
	 * 这样我们就能知道下次选择的数的范围，如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。下次找的时候，还是找一半。
	 *
	 * 注意
	 * 我们比较的mid而不是nums[mid],因为mid是下标，所以判断式应为count > mid，最后返回min
	 */
	public static int findDuplicate(int[] nums) {
		int min = 0;
		int max = nums.length - 1;

		while (min <= max) {
			int mid = min + (max - min)/2;
			//int mid = (max + min) / 2;  // 找到中间那个数
			int count = 0;
			for (int i = 0; i < nums.length; i++) {  // 计算总数组中有多少个数小于等于中间数
				if (nums[i] <= mid) {
					count++;
				}
			}
			if (count > mid) {  // 如果【小于等于中间数】的数量大于中间数，说明前半部分必有重复
				max = mid - 1;
			} else {  	// 否则后半部分必有重复
				min = mid + 1;
			}
		}
		return min;
	}


	public static void main(String[] args) {
//		System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
//		System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
		System.out.println(findDuplicate1(new int[]{1,3,4,2,2}));
//		System.out.println(findDuplicate1(new int[]{3,1,3,4,2}));
	}

	/**
	 * 映射找环法
	 * 复杂度
	 * 时间 O(N) 空间 O(1)
	 *
	 * 思路
	 * 假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。
	 *
	 * 比如数组是213,则映射关系为0->2, 1->1, 2->3。
	 * 假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。
	 * 如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。
	 * 实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。
	 *
	 * 但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。
	 *
	 * 这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
	 *
	 * 所以该题实际上就是找环路起点的题，和Linked List Cycle II一样。
	 * 我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
	 * 这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。
	 * 对这个找环起点算法不懂的，请参考Floyd's Algorithm。
	 *
	 * 注意
	 * 第一次找快慢指针相遇用do-while循环
	 */

	public static int findDuplicate1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {
				// case like [1,2,3,1]
				// 把一个指针放回到开头的地方
				slow = 0;
				while (slow != fast) {
					slow = nums[slow];
					fast = nums[fast];
				}
				return slow;
			}
		}
	}

}
