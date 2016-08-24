import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.getRow(3);

	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		if (rowIndex == 0)
			return res;
		int pre[] = new int[rowIndex + 1];
		pre[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				pre[j] = pre[j - 1] + pre[j];
			}
			pre[i] = 1;
		}
		for (int i = 1; i <= rowIndex; i++) {
			System.out.print(pre[i] + ",");
			res.add(pre[i]);
		}
		return res;
	}
}
