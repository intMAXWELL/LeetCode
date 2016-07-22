/**
 * 
 * @author Demon 2016.7.22
 * 
 *
 *         Given a non-negative integer num, repeatedly add all its digits until
 *         the result has only one digit.
 * 
 *         For example:
 * 
 *         Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2
 *         has only one digit, return it.
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	// It's a digital root problem
	// see https://en.wikipedia.org/wiki/Digital_root for more detail
	public int addDigits(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
	}

}
