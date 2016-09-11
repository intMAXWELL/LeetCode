import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Demon 0216.9.11
 * 
 *         Given a string s and a dictionary of words dict, determine if s can
 *         be segmented into a space-separated sequence of one or more
 *         dictionary words.
 * 
 *         For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 *         Return true because "leetcode" can be segmented as "leet code"
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "leetcode";
		Set<String> wordSet = new HashSet<String>();
		wordSet.add("leet");
		wordSet.add("code");
		System.out.println(solution.wordBreak(s, wordSet));
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean dp[] = new boolean[s.length() + 1];
		Arrays.fill(dp, false);
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
	}
}
