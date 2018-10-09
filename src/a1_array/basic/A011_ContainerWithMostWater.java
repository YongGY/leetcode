package a1_array.basic;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author William
 *
 * Analysis
 * Initially we can assume the result is 0. Then we scan from both sides. 
 * 
 * If leftHeight < rightHeight, move right and find a value that is greater than leftHeight. 
 * Similarily, if leftHeight > rightHeight, move left and find a value that is greater than rightHeight. 
 * Additionally, keep tracking the max value.
 *
 * https://segmentfault.com/a/1190000008824222
 *
 * https://www.cnblogs.com/zxqstrong/p/5274938.html
 */
public class A011_ContainerWithMostWater {

	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}

		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int area = Math.min(height[left], height[right])  *  (right - left);
			max = Math.max(max, area);
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}

}