/**
 * 
 * @author Demon 2016.8.23
 * 
 *         Given a sorted array, remove the duplicates in place such that each
 *         element appear only once and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this in
 *         place with constant memory.
 * 
 *         For example, Given input array nums = [1,1,2],
 * 
 *         Your function should return length = 2, with the first two elements
 *         of nums being 1 and 2 respectively. It doesn't matter what you leave
 *         beyond the new length.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };
		int res = solution.removeDuplicates(nums);
		System.out.println(res);
		for (int a : nums)
			System.out.print(a + ",");
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int b = 1;
		for (int a = 1; a < nums.length; a++) {
			if (nums[a] == nums[a - 1])
				continue;
			else {
				if (a != b)
					nums[b] = nums[a];
				b++;
			}
		}
		return b;
	}
}
