/**
 * 
 * @author Demon 2016.8.13
 * 
 *         Given a positive integer, return its corresponding column title as
 *         appear in an Excel sheet.
 * 
 *         For example:
 * 
 *         1 -> A
 * 
 *         2 -> B
 * 
 *         3 -> C
 * 
 *         ...
 * 
 *         26-> Z
 * 
 *         27 -> AA
 * 
 *         28 -> AB
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.convertToTitle(27));
		System.out.println(solution.convertToTitle(28));
		System.out.println(solution.convertToTitle(26));
		System.out.println(solution.convertToTitle(2));
		System.out.println(solution.convertToTitle(703));
	}

	public String convertToTitle(int n) {
		if (n <= 0)
			return "";
		StringBuilder sb = new StringBuilder(8);
		int b;
		while (n != 0) {
			b = n % 26;
			n = n / 26;
			if (b == 0) {
				sb.insert(0, 'Z');
				n--;
			} else {
				sb.insert(0, (char) ('A' - 1 + b));
			}
		}
		return sb.toString();
	}
}
