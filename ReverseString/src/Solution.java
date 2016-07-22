import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 
 * @author Demon
 * 
 *         Write a function that takes a string as input and returns the string
 *         reversed.
 * 
 *         Example: Given s = "hello", return "olleh".
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		System.out.println(new Solution().reverseString(scanner.next()));
		scanner.close();
	}

	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		char[] c = s.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			sb.append(c[i]);
		}
		return sb.toString();
	}
}
