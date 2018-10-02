/** Min Stack
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		this.stack.push(x);
		if (this.minStack.isEmpty() || x <= this.minStack.peek()) {
			this.minStack.push(x);
		}
	}

	public void pop() {
		if (this.stack.pop().equals(this.minStack.peek())) {
			this.minStack.pop();
		}
	}

	public int top() {
		return this.stack.peek();
	}

	public int getMin() {
		return this.minStack.peek();
	}
}
	/**
	 * Longest Mountain in Array
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

 

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
	 */
	public int longestMountain(int[] A) {
		int n = A.length, res = 0;
		int[] left = new int[n], right = new int[n];
		for (int i = n - 2; i >= 0; --i) {
			if (A[i] > A[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (i > 0 && A[i] > A[i - 1]) {
				left[i] = left[i - 1] + 1;
			}
			if (left[i] > 0 && right[i] > 0) {
				res = Math.max(res, left[i] + right[i] + 1);
			}
		}
		return res;
	}

	public int longestMountain2(int[] A) {
		int n = A.length, res = 0;
		int[] right = new int[n];
		for (int i = n - 2; i >= 0; --i) {
			if (A[i] > A[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}
		int prev = 0, cur = 0;
		for (int i = 1; i < n; ++i) {
			if (A[i] > A[i - 1]) {
				cur = prev + 1;
			} else {
				cur = 0;
			}
			if (cur > 0 && right[i] > 0) {
				res = Math.max(res, cur + right[i] + 1);
			}
			prev = cur;
		}
		return res;
	}
	
	enum MountainStatus {
		INVALID, DOWN, // in mountain
		UP;
	}

	public int longestMountain3(int[] A) {
		// max: max length, cur: length of current subarrary
		int max = 0, cur = 0, n = A.length;
		MountainStatus status = MountainStatus.INVALID;

		for (int i = 1; i < n; i++) {
			if (A[i - 1] < A[i]) {
				switch (status) {
				case UP:
					cur++; // "up" continues
					break;
				default: // DOWN or INVALID
					status = MountainStatus.UP;
					max = Math.max(max, cur);
					cur = 2; // new "up" starts with length 2
				}
			} else if (A[i - 1] > A[i]) {
				switch (status) {
				case DOWN:
					cur++; // mountain continues
					break;
				case UP:
					cur++; // mountain found (and "down" starts)
					status = MountainStatus.DOWN;
					break;
				default:
				}
			} else { // if (A[i-1] == A[i])
				if (status == MountainStatus.DOWN) {
					max = Math.max(max, cur);
				}
				// not mountain, resets
				status = MountainStatus.INVALID;
				cur = 0;
			}
		}

		if (status == MountainStatus.DOWN && cur > max) {
			max = cur; // moutain upon loop end
		}

		return max;
	}

	/**
	 * Two Sum 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
	 */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			Integer index = map.get(target - numbers[i]);
			if (index != null) {
				return new int[] { index, i };
			}
			map.put(numbers[i], i);
		}
		return null;
	}
	
	/**
	 * Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int[] indice = new int[2];
		if (numbers == null || numbers.length < 2) {
			return indice;
		}
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (v > target) {
				right--;
			} else {
				left++;
			}
		}
		return indice;
	}
	
	/**
	 * 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
O(N^2)
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			while (i > 0 && i < n - 2 && nums[i - 1] == nums[i]) {
				i++;
			}
			int j = i + 1;
			int k = n - 1;
			int sum = -nums[i];
			while (j < k) {
				int sumTwo = nums[j] + nums[k];
				if (sumTwo < sum) {
					j++;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
				} else if (sumTwo > sum) {
					k--;
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
				} else {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					k--;
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
					j++;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int n = num.length, diff = Integer.MAX_VALUE, result = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			int sum = target - num[i];
			while (j < k) {
				int sumTwo = num[j] + num[k];
				if (sum == sumTwo) {
					return target;
				}
				if (sumTwo < sum) {
					if (sum - sumTwo < diff) {
						diff = sum - sumTwo;
						result = target - diff;
					}
					j++;
				} else if (sumTwo > sum) {
					if (sumTwo - sum < diff) {
						diff = sumTwo - sum;
						result = target + diff;
					}
					k--;
				}
			}
		}
		return result;
	}

	/**
	 * 4Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note: The solution set must not contain duplicate quadruplets.
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		if (n < 4) {
			return result;
		}
		Arrays.sort(nums);
		int max = nums[n - 1];
		if (4 * nums[0] > target || 4 * max < target) {
			return result;
		}

		for (int h = 0; h < n - 3; h++) {
			if (h > 0 && nums[h - 1] == nums[h]) {
				// avoid duplicate
				continue;
			}
			if (nums[h] + 3 * max < target) {// nums[h] is too small
				continue;
			}
			if (4 * nums[h] > target) {// nums[h] is too large
				break;
			}
			if (4 * nums[h] == target) { // nums[h] is the boundary
				if (h + 3 < n && nums[h + 3] == nums[h]) {
					result.add(Arrays.asList(nums[h], nums[h], nums[h], nums[h]));
				}
				break;
			}
			int i = h + 1;
			while (i < n - 2) {
				int j = i + 1;
				int k = n - 1;
				int sum = target - nums[h] - nums[i];
				while (j < k) {
					int sumTwo = nums[j] + nums[k];
					if (sumTwo < sum) {
						j++;
						while (j < k && nums[j] == nums[j - 1]) {
							j++;
						}
					} else if (sumTwo > sum) {
						k--;
						while (j < k && nums[k] == nums[k + 1]) {
							k--;
						}
					} else {
						result.add(Arrays.asList(nums[h], nums[i], nums[j], nums[k]));
						k--;
						while (j < k && nums[k] == nums[k + 1]) {
							k--;
						}
						j++;
						while (j < k && nums[j] == nums[j - 1]) {
							j++;
						}
					}
				}
				i++;
				while (i < n - 2 && nums[i - 1] == nums[i]) {
					i++;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 4) {
			return res;
		}

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target) {
			return res;
		}

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1]) { // avoid duplicate
				continue;
			}
			if (z + 3 * max < target) { // z is too small
				continue;
			}
			if (4 * z > target) { // z is too large
				break;
			}
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z) {
					res.add(Arrays.asList(z, z, z, z));
				}
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	private void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList,
			int z1) {
		if (low >= high) {
			return;
		}

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target) {
			return;
		}

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) { // avoid duplicate
				continue;
			}
			if (z + 2 * max < target) { // z is too small
				continue;
			}

			if (3 * z > target) { // z is too large
				break;
			}

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z) {
					fourSumList.add(Arrays.asList(z1, z, z, z));
				}
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}
	}

	/*
	 * Find all possible distinguished two numbers adding up to the target in
	 * sorted array nums[] between indices low and high. If there are, add all
	 * of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	private void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList, int z1,
			int z2) {
		if (low >= high) {
			return;
		}

		if (2 * nums[low] > target || 2 * nums[high] < target) {
			return;
		}

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i])
					; // avoid duplicate
				x = nums[j];
				while (i < --j && x == nums[j])
					; // avoid duplicate
			}
			if (sum < target) {
				i++;
			}
			if (sum > target) {
				j--;
			}
		}
		return;
	}
	
	/**
	 * 4Sum II
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
Example:
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
	Time complexity:  O(n^2)
	Space complexity: O(n^2)
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
			}
		}

		return res;
	}
