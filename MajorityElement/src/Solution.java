/**
 * 
 * @author Demon 2016.8.14
 * 
 *         Given an array of size n, find the majority element. The majority
 *         element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 *         You may assume that the array is non-empty and the majority element
 *         always exist in the array.
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}

	public int majorityElement(int[] nums) {
		int res = 0, count = 0;
		for (int a : nums) {
			if (a == res)
				count++;
			else if (count == 0) {
				res = a;
				count = 1;
			} else
				count--;
		}
		return res;
	}

}
