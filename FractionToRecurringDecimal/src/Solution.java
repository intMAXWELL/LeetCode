import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Demon 2016.8.2
 * 
 *         Given two integers representing the numerator and denominator of a
 *         fraction, return the fraction in string format.
 * 
 *         If the fractional part is repeating, enclose the repeating part in
 *         parentheses.
 * 
 *         For example,
 * 
 *         Given numerator = 1, denominator = 2, return "0.5". Given numerator =
 *         2, denominator = 1, return "2". Given numerator = 2, denominator = 3,
 *         return "0.(6)".
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.fractionToDecimal(-1,
		// Integer.MIN_VALUE));
		System.out.println(solution.fractionToDecimal(Integer.MIN_VALUE, 1));
		// System.out.println(solution.fractionToDecimal(2, 3));
		// System.out.println(solution.fractionToDecimal(1, 2));
		// System.out.println(solution.fractionToDecimal(2, 1));
		// System.out.println(solution.fractionToDecimal(1, 333));
		// System.out.println(solution.fractionToDecimal(-2, 5));

	}

	class Division {
		long quotients;
		long remainder;

		public Division(long q, long r) {
			quotients = q;
			remainder = r;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Division other = (Division) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (quotients != other.quotients)
				return false;
			if (remainder != other.remainder)
				return false;
			return true;
		}

		private Solution getOuterType() {
			return Solution.this;
		}
	}

	public boolean contrarySign(int a, int b) {
		return (a > 0 && b < 0) || (a < 0 && b > 0);
	}

	/*
	 * Consider Integer.MIN_VALUE.
	 * 
	 * Think about when to add bracket.
	 * 
	 * I Think the solution can be improved.
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		if (contrarySign(numerator, denominator))
			sb.append("-");
		long numerator1 = Math.abs((long) numerator);
		long denominator1 = Math.abs((long) denominator);
		long integer = numerator1 / denominator1;
		long decimal = numerator1 % denominator1;
		if (decimal == 0) // No Decimal
			return sb.append(integer).toString();
		sb.append(integer).append(".");
		List<Division> pattern = new ArrayList<Division>();
		Division d;
		while (decimal != 0) {
			integer = decimal * 10 / denominator1;
			decimal = (decimal * 10) % denominator1;
			d = new Division(integer, decimal);
			if (pattern.contains(d)) {
				int index = pattern.indexOf(d);
				for (int i = 0; i < index; i++)
					sb.append(pattern.get(i).quotients);
				sb.append("(");
				for (; index < pattern.size(); index++)
					sb.append(pattern.get(index).quotients);
				sb.append(")");
				return sb.toString();
			}
			pattern.add(d);
		}
		for (Division i : pattern)
			sb.append(i.quotients);
		return sb.toString();
	}
}
