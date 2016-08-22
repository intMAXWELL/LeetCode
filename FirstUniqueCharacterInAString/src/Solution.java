import java.util.HashMap;

/**
 * 
 * @author Demon 2016.8.22
 * 
 *         Given a string, find the first non-repeating character in it and
 *         return it's index. If it doesn't exist, return -1.
 * 
 *         Examples:
 * 
 *         s = "leetcode" return 0.
 * 
 *         s = "loveleetcode", return 2.
 * 
 *         Note: You may assume the string contain only lowercase letters.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.firstUniqChar("leetcode"));
		System.out.println(solution.firstUniqChar("loveleetcode"));
	}

	public int firstUniqChar(String s) {
		HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();
		for (Character c : s.toCharArray()) {
			hashMap.put(c, hashMap.containsKey(c) ? false : true);
		}
		for (int i = 0; i < s.length(); i++) {
			if (hashMap.getOrDefault(s.charAt(i), false))
				return i;
		}
		return -1;
	}
}
