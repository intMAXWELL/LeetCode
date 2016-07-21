/**
 * 
 */
package net.bingyan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Demon Given two integers n and k, return all possible combinations of
 *         k numbers out of 1 ... n.
 *
 *         For example, If n = 4 and k = 2, a solution is:
 *
 *         [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	}

	public static List<List<Integer>> combine(int n, int k) {
		if (k == n || k == 0) {
			List<Integer> row = new LinkedList<>();
			for (int i = 1; i <= k; ++i) {
				row.add(i);
			}
			return new LinkedList<>(Arrays.asList(row));
		}
		List<List<Integer>> result = combine(n - 1, k - 1);
		result.forEach(e -> e.add(n));
		result.addAll(combine(n - 1, k));
		return result;
	}

}
