/**
 * 
 * @author Demon 2016.8.15
 * 
 *         Given an integer, write a function to determine if it is a powers of
 *         two.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPowerOfTwo(1024));
		System.out.println(solution.isPowerOfTwo(1023));
		System.out.println(solution.isPowerOfTwo(1));
	}

	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
}
