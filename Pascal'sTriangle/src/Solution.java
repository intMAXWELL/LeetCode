import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Demon 2016.8.7
 * 
 *         Given numRows, generate the first numRows of Pascal's triangle.
 * 
 *         For example, given numRows = 5, Return
 * 
 *         [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generate(5));
	}
	
	/*
	 * Time: 2ms
	 * K(n,k) = K(n-1, k-1) + K(n-1, k)
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return resList;
		// Initial
		List<Integer> value = new ArrayList<Integer>();
		value.add(1);
		resList.add(value);
		for (int i = 1; i < numRows; i++) {
			value = new ArrayList<Integer>();
			value.add(1);
			for (int j = 1; j <= i - 1; j++) {
				value.add(resList.get(i - 1).get(j - 1)
						+ resList.get(i - 1).get(j));
			}
			value.add(1);
			resList.add(value);
		}
		return resList;
	}
}
