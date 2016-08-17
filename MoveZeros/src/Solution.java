/**
 * 
 * @author Demon 2016.8.17
 * 
 *         Given an array nums, write a function to move all 0's to the end of
 *         it while maintaining the relative order of the non-zero elements.
 * 
 *         For example, given nums = [0, 1, 0, 3, 12], after calling your
 *         function, nums should be [1, 3, 12, 0, 0].
 * 
 *         Note: You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int a[] = new int[] { 0, 1, 0, 3, 12 };
		solution.moveZeroes(a);
	}

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int cursor = 0;
		for (int a : nums) {
			if (a != 0)
				nums[cursor++] = a;
		}
		for (; cursor < nums.length; cursor++)
			nums[cursor] = 0;
		for (int a : nums)
			System.out.print(a + ",");

	}

}
