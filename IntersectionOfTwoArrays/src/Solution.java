import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Demon 2016.8.4
 * 
 *         Given two arrays, write a function to compute their intersection.
 * 
 *         Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 *         Note: Each element in the result should appear as many times as it
 *         shows in both arrays. The result can be in any order.
 * 
 *         Follow up: What if the given array is already sorted? How would you
 *         optimize your algorithm? What if nums1's size is small compared to
 *         nums2's size? Which algorithm is better? What if elements of nums2
 *         are stored on disk, and the memory is limited such that you cannot
 *         load all elements into the memory at once?
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n1[] = { 1, 2, 2, 1 };
		int n2[] = { 2, 2 };
		int res[] = solution.intersect(n1, n2);
		for (int a : res)
			System.out.print(a + ",");
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> num1Map = new HashMap<Integer, Integer>();
		int count = nums1.length;
		ArrayList<Integer> resList = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) { // Store in hash map
			if (num1Map.containsKey(nums1[i])) {
				num1Map.put(nums1[i], num1Map.get(nums1[i]) + 1);
			} else {
				num1Map.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (num1Map.containsKey(nums2[i])) {
				resList.add(nums2[i]);
				if (num1Map.get(nums2[i]) == 1)
					num1Map.remove(nums2[i]);
				else {
					num1Map.put(nums2[i], num1Map.get(nums2[i]) - 1);
				}
				if (--count == 0)
					break;
			}
		}
		int res[] = new int[resList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = resList.get(i);
		}
		return res;
	}
}
