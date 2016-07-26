/**
 * 
 * @author Demon 2015.7.27
 * 
 *         Given a non-negative number represented as an array of digits, plus
 *         one to the number.
 * 
 *         The digits are stored such that the most significant digit is at the
 *         head of the list.
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0; // Digits[i] == 9
		}
		int a[] = new int[digits.length + 1]; // The digits array is like [9, 9, ... , 9]
		a[0] = 1;
		return a;
	}
}
