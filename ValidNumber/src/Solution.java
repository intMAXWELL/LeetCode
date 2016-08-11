/**
 * 
 * @author Demon 2016.8.10
 * 
 *         Validate if a given string is numeric.
 * 
 *         Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" =>
 *         false "2e10" => true Note: It is intended for the problem statement
 *         to be ambiguous. You should gather all requirements up front before
 *         implementing one.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.isNumber(" "));
		// System.out.println(solution.isNumber("0"));
		// System.out.println(solution.isNumber(" 0.1 "));
		// System.out.println(solution.isNumber("abc"));
		// System.out.println(solution.isNumber("1 a"));
		// System.out.println(solution.isNumber("2e10"));
		// System.out.println(solution.isNumber("2e"));
		System.out.println(solution.isNumber(".1"));
	}

	public boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return true;
		// char[] buf = s.trim().toCharArray();
		// int end = buf.length;
		// if (end <= 0)
		// return false;
		// int cursor = 0;
		// if (isDigit(buf[cursor])) {
		// if (++cursor == end)
		// return true;
		// } else
		// return false;
		// if (isDigit(buf[cursor])) {
		// while (isDigit(buf[cursor])) {
		// if (++cursor == end)
		// return true;
		// }
		// if (buf[cursor++] == '.') {
		// return startFromD(buf, cursor, end);
		// } else
		// return false;
		// } else if (buf[cursor] == '.')
		// return startFromD(buf, ++cursor, end);
		// else if (buf[cursor] == 'e')
		// return startFromE(buf, ++cursor, end);
		// else
		// return false;
	}

	public boolean startFromD(char[] buf, int cursor, int end) {
		if (cursor >= end)
			return false;
		if (buf[cursor] == 'e') {
			return startFromE(buf, ++cursor, end);
		} else if (isDigit(buf[cursor])) {
			while (isDigit(buf[cursor])) {
				if (++cursor == end)
					return true;
			}
			if (buf[cursor++] == 'e') {
				return startFromE(buf, cursor, end);
			} else
				return false;
		}
		return false;
	}

	public boolean startFromE(char[] buf, int cursor, int end) {
		if (cursor >= end)
			return false;
		if (isDigit(buf[cursor])) {
			while (isDigit(buf[cursor])) {
				if (++cursor == end)
					return true;
			}
		} else if (buf[cursor] == '+' || buf[cursor] == '-') {
			if (++cursor >= end)
				return false;
			if (isDigit(buf[cursor])) {
				while (isDigit(buf[cursor])) {
					if (++cursor == end)
						return true;
				}
			} else
				return false;
		}
		return false;
	}

	public boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

}
