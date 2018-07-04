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
 * @author William
 *
 */
public class A29_042TrappingRainWater {
    
	public static int trap(int[] height) {

		int left = 0;
		int right = height.length - 1;

		int leftBarrier = 0;
		int rightBarrier = 0;
		int result = 0;

		while (left <= right) {
			// left小
			if (leftBarrier <= rightBarrier) {
				// there could be a basin between leftBarrier and rightBarrier and left side is lower one
				if (height[left] > leftBarrier) {
					leftBarrier = height[left]; // update left barrier
				} else {
					result += leftBarrier - height[left];  // trap water (leftBarrier - height[left]) * 1
				}
				left++;
			} else {//right小
				if (height[right] > rightBarrier) {
					rightBarrier = height[right]; // update right barrier
				} else {
					result += rightBarrier - height[right]; // trap water (rightBarrier - height[right]) * 1
				}
				right--;
			}
		}
		return result;
	}
    
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
