/**
 * 
 * @author Demon 2016.8.20
 * 
 *         Given an integer, write a function to determine if it is a power of
 *         three.
 * 
 *         Follow up: Could you do it without using any loop / recursion?
 * 
 * 
 *
 */
public class Solution {

	public static void main(String[] args) {

	}

	/*
	 * maxPowerOfThree = 1162261467:
	 * 
	 * It is worthwhile to mention that it works only when the base is prime.
	 * For example, we cannot use this algorithm to check if a number is a power
	 * of 4 or 6 or any other composite number.
	 */
	public boolean isPowerOfThree(int n) {
		return n > 0 && (1162261467 % n == 0);
	}

}
