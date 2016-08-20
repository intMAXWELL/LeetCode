/**
 * 
 * @author Demon 2016.8.20
 * 
 *         Write a function that takes an unsigned integer and returns the
 *         number of ¡¯1' bits it has (also known as the Hamming weight).
 * 
 *         For example, the 32-bit integer ¡¯11' has binary representation
 *         00000000000000000000000000001011, so the function should return 3.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight(11));
	}

	public int hammingWeight(int n) {
		return Integer.bitCount(n);
	}

}
