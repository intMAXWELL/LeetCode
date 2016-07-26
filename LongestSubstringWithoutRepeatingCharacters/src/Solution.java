import java.util.Arrays;

/**
 * 
 * @author Demon 2016.7.26
 * 
 *         Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Examples:
 * 
 *         Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 *         Given "bbbbb", the answer is "b", with the length of 1.
 * 
 *         Given "pwwkew", the answer is "wke", with the length of 3. Note that
 *         the answer must be a substring, "pwke" is a subsequence and not a
 *         substring.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(solution.lengthOfLongestSubstring("dvdf"));
		System.out.println(solution.lengthOfLongestSubstring(""));
	}

	public int lengthOfLongestSubstring(String s) {
		char[] a = s.toCharArray();
		int dict[] = new int[256]; // Record the final position
		Arrays.fill(dict, -1);
		int max = 0, start = -1; // Start: the penultimate repeat character.
									// For "abcabcbb", it can be -1, 0, 1, 2, 4, 6 
									// and For "dvdf", it can be -1, 0
		for (int i = 0; i < a.length; i++) {
			if (dict[a[i]] > start) {
				start = dict[a[i]];
			}
			dict[a[i]] = i; // Record the position a character last seen
			max = Math.max(max, i - start);
		}
		return max;
	}
}
