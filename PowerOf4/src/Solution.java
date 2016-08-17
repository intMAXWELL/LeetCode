/**
 * 
 * @author Demon 2016.8.17
 * 
 *         Given an integer (signed 32 bits), write a function to check whether
 *         it is a power of 4.
 * 
 *         Example: Given num = 16, return true. Given num = 5, return false.
 * 
 *         Follow up: Could you solve it without loops/recursion?
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPowerOfFour(4));
		System.out.println(solution.isPowerOfFour(5));
		System.out.println(solution.isPowerOfFour(16));
	}

	/*
	 * Integer.bitCount(n - 1) % 2 == 0 indicates that the only '1' bit should be
	 * locate at the odd location.
	 */
	public boolean isPowerOfFour(int n) {
		return n > 0 && ((n & (n - 1)) == 0)
				&& Integer.bitCount(n - 1) % 2 == 0;
	}
}
