/**
 * 
 * @author Demon Compare two version numbers version1 and version2. If version1
 *         > version2 return 1, if version1 < version2 return -1, otherwise
 *         return 0.
 * 
 *         You may assume that the version strings are non-empty and contain
 *         only digits and the . character. The . character does not represent a
 *         decimal point and is used to separate number sequences. For instance,
 *         2.5 is not "two and a half" or "half way to version three", it is the
 *         fifth second-level revision of the second first-level revision.
 * 
 *         Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 <
 *         13.37
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().compareVersion("1.1.3", "1.1.12"));

	}

	public int compareVersion(String version1, String version2) {
		char[] v1 = version1.toCharArray();
		char[] v2 = version2.toCharArray();
		int cursor1 = 0, cursor2 = 0;
		int tmp1 = 0, tmp2 = 0;
		while (cursor1 < v1.length || cursor2 < v2.length) {
			while (cursor1 < v1.length && v1[cursor1] != '.') {
				tmp1 += tmp1 * 10 + (v1[cursor1++] - 48);
			}
			while (cursor2 < v2.length && v2[cursor2] != '.') {
				tmp2 += tmp2 * 10 + (v2[cursor2++] - 48);
			}
			if (tmp1 < tmp2)
				return -1;
			else if (tmp1 > tmp2)
				return 1;
			tmp1 = tmp2 = 0;
			cursor1++;
			cursor2++;
		}
		return 0;
	}
}
