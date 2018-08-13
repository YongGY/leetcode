package array.basic;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * **************There is a graph here**************
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped. 
 * Thanks Marcos for contributing this image!
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * http://www.bubuko.com/infodetail-843085.html
 *
 * https://www.cnblogs.com/zhxshseu/p/1500af07ede3bc9b59c7a22bbf616726.html
 * @author William
 *
 */
public class A042_TrappingRainWater {

	public static int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int result = 0;
		int leftMax = 0;
		int rightMax = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				leftMax = Math.max(height[left], leftMax);
				result += leftMax - height[left];
				left++;
			} else {
				rightMax = Math.max(height[right], rightMax);
				result += rightMax - height[right];
				right--;
			}
		}
		return result;
	}

//	public int trap1(int[] height) {
//
//		int left = 0;
//		int right = height.length - 1;
//
//		int leftBarrier = 0;
//		int rightBarrier = 0;
//		int result = 0;
//
//		while (left <= right) {
//			if (leftBarrier <= rightBarrier) {
//				// there could be a basin between leftBarrier and rightBarrier
//				// and left side is lower one
//				if (height[left] > leftBarrier) {
//					// update left barrier
//					leftBarrier = height[left];
//				} else {
//					// trap water (leftBarrier - height[left]) * 1
//					result += leftBarrier - height[left];
//				}
//				left++;
//			} else {
//				if (height[right] > rightBarrier) {
//					// update right barrier
//					rightBarrier = height[right];
//				} else {
//					// trap water (rightBarrier - height[right]) * 1
//					result += rightBarrier - height[right];
//				}
//				right--;
//			}
//		}
//		return result;
//	}

    public static void main(String[] args) {
        int[] height = {4,2,1,4,2,1,2,3};
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
