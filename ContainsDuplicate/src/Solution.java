import java.util.HashSet;

/**
 * 
 * @author Demon 2016.8.18
 * 
 *         Given an array of integers, find if the array contains any
 *         duplicates. Your function should return true if any value appears at
 *         least twice in the array, and it should return false if every element
 *         is distinct.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
	}

	public boolean containsDuplicate(int[] nums) {
		if (nums.length < 2)
			return false;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int a : nums) {
			if (!hashSet.add(a))
				return true;
		}
		return false;
	}
}
