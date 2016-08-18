/**
 * 
 * @author Demon 2016.8.18
 * 
 *         Given two strings s and t, write a function to determine if t is an
 *         anagram of s.
 * 
 *         For example, s = "anagram", t = "nagaram", return true. s = "rat", t
 *         = "car", return false.
 *
 */
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isAnagram("anagram", "nagaram"));
		System.out.println(solution.isAnagram("rat", "car"));
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int map[] = new int[26];
		for (Character c : s.toCharArray())
			map[c - 'a']++;
		for (Character c : t.toCharArray()) {
			if (--map[c - 'a'] < 0)
				return false;
		}
		return true;
	}
}
