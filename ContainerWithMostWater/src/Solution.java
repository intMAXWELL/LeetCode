/**
 * 
 * @author Demon 2016.8.9
 * 
 *         Given n non-negative integers a1, a2, ..., an, where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 *         which together with x-axis forms a container, such that the container
 *         contains the most water.
 * 
 *         Note: You may not slant the container.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] height = { 1, 2, 1 };
		System.out.println(solution.maxArea(height));
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		int start = 0, end = height.length - 1;
		while (start < end) {
			maxArea = Math.max(maxArea,
					(end - start) * Math.min(height[start], height[end]));
			if (height[start] < height[end])
				start++;
			else {
				end--;
			}
		}
		return maxArea;

	}
}
