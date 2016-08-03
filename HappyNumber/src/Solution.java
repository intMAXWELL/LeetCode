import java.util.HashSet;

/**
 * 
 * @author Demon 2016.8.3
 * 
 *         Write an algorithm to determine if a number is "happy".
 * 
 *         A happy number is a number defined by the following process: Starting
 *         with any positive integer, replace the number by the sum of the
 *         squares of its digits, and repeat the process until the number equals
 *         1 (where it will stay), or it loops endlessly in a cycle which does
 *         not include 1. Those numbers for which this process ends in 1 are
 *         happy numbers.
 * 
 *         Example: 19 is a happy number
 * 
 *         12 + 92 = 82
 * 
 *         82 + 22 = 68
 * 
 *         62 + 82 = 100
 * 
 *         12 + 02 + 02 = 1
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.isHappy(19));
		// System.out.println(solution.isHappy(0));
		System.out.println(solution.isHappy(2));
	}

	public boolean isHappy(int n) {
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		HashSet<Integer> cache = new HashSet<Integer>();
		int sum = 0;
		while (!cache.contains(n)) {
			cache.add(n);
			int quotients = n, remainder = 0;
			while (quotients != 0) { // Calculate each place
				remainder = quotients % 10;
				quotients = quotients / 10;
				sum += remainder * remainder;
			}
			if (sum == 0)
				return false;
			if (sum == 1)
				return true;
			n = sum;
			sum = 0;
		}
		return false;
	}
}
