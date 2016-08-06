/**
 * 
 * @author Demon 2016.8.6
 * 
 *         Given a non-negative integer n, count all numbers with unique digits,
 *         x, where 0 ¡Ü x < 10n.
 * 
 *         Example: Given n = 2, return 91. (The answer should be the total
 *         numbers in the range of 0 ¡Ü x < 100, excluding
 *         [11,22,33,44,55,66,77,88,99])
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countNumbersWithUniqueDigits(3));
	}

	// DP
	// F(n) = F(n - 1) + (11 - n) * (F(n - 1) - F(n - 2))
	/*
	 * For example: n = 3
	 * F(3) = F(2) + 8*(F(2)-F(1))
	 * F(2): Numbers with 2 or 1 unique digits such as 1,2,12,13....
	 * F(2)-F(1):Numbers with only 2 unique digits such as 11,12,13....
	 * 8: since 2 unique digits are used, there are 10-2 digits can be used.
	 */
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n >= 10)
			return 0;
		int res[] = new int[10];
		res[0] = 1;
		res[1] = 10;
		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + (11 - i) * (res[i - 1] - res[i - 2]);
		}
		return res[n];
	}
}
