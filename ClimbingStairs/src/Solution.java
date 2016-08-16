/**
 * 
 * @author Demon 2016.8.16
 * 
 *         You are climbing a stair case. It takes n steps to reach to the top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.climbStairs(3));
		System.out.println(solution.climbStairs(4));
		System.out.println(solution.climbStairs(5));
	}

	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		int A[] = new int[n + 1];
		A[1] = 1;
		A[2] = 2;
		for (int i = 3; i <= n; i++) {
			A[i] = A[i - 1] + A[i - 2];
		}
		return A[n];
	}

}
