/**
 * 
 * @author Demon 2016.7.28
 * 
 *         Write a function that takes a string as input and reverse only the
 *         vowels of a string.
 * 
 *         Example 1: Given s = "hello", return "holle".
 * 
 *         Example 2: Given s = "leetcode", return "leotcede".
 * 
 *         Note: The vowels does not include the letter "y".
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseVowels("hello"));
		System.out.println(solution.reverseVowels("leetcode"));
		System.out.println(solution.reverseVowels("OE"));
		System.out.println(solution.reverseVowels("aA"));
	}

	static char vowels[] = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'O', 'I', 'U' };

	public boolean isVowels(char a) {
		for (char v : vowels) {
			if (a == v)
				return true;
		}
		return false;
	}

	public String reverseVowels(String s) {
		char c[] = s.toCharArray();
		int front = 0, tail = c.length - 1;
		while (front < tail) {
			while (!isVowels(c[front]) && front < c.length - 1) { // Find a vowel in the front
				front++;
			}
			while (!isVowels(c[tail]) && tail > 0) { // Find a vowel in the tail
				tail--;
			}
			if (front < tail) { // Swap
				char tmp = c[front];
				c[front] = c[tail];
				c[tail] = tmp;
				front++;
				tail--;
			}
		}
		return new String(c);
	}
}
