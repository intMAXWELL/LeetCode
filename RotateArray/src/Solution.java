/**
 * 
 * @author Demon 2016.8.9
 * 
 *         Rotate an array of n elements to the right by k steps.
 * 
 *         For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is
 *         rotated to [5,6,7,1,2,3,4].
 * 
 *         Note: Try to come up as many solutions as you can, there are at least
 *         3 different ways to solve this problem.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = { 1, 2, 3, 4, 5, 6, 7 };
		int[] test1 = { 1, 2 };
		int[] test2 = { 1, 2, 3, 4, 5, 6 };
		int[] test3 = { 1 };
		solution.rotate(test, 3);
		solution.rotate(test1, 3);
		solution.rotate(test2, 2);
		solution.rotate(test3, 1);
		;
	}
	
	/*
	 * O(n) time and O(1) space
	 */
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		if (k <= 0 || nums.length <= 0)
			return;
		int length = nums.length, count = length, start = 0, pre = nums[0], tmp = 0, step = 0;
		while (count != 0) {
			start = (start + k) % length;
			count--;
			if (step == start) {
				nums[start++] = pre;
				pre = nums[start];
				step++;
				continue;
			}
			tmp = nums[start];
			nums[start] = pre;
			pre = tmp;

		}
		for (int i : nums)
			System.out.print(i + ",");
		System.out.println();
	}
}
