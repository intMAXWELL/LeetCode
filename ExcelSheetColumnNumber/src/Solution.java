/**
 * 
 * @author Demon 2016.8.14
 * 
 *         Related to question Excel Sheet Column Title
 * 
 *         Given a column title as appear in an Excel sheet, return its
 *         corresponding column number.
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.titleToNumber("A"));
		System.out.println(solution.titleToNumber("B"));
		System.out.println(solution.titleToNumber("Z"));
		System.out.println(solution.titleToNumber("AA"));
		System.out.println(solution.titleToNumber("AB"));
	}

	public int titleToNumber(String s) {
		if (s.isEmpty())
			return 0;
		int res = 0, tmp = 0;
		for (int i = 0; i < s.length(); i++) {
			tmp = (int) (s.charAt(s.length() - 1 - i) - 'A' + 1);
			res += tmp * Math.pow(26, i);
		}
		return res;
	}
}
