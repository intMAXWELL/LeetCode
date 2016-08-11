import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Demon 2016.8.11
 * 
 *         Given a non-empty array of integers, return the k most frequent
 *         elements.
 * 
 *         For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 *         Note:
 * 
 *         You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
 * 
 *         Your algorithm's time complexity must be better than O(n log n),
 *         where n is the array's size.
 *
 */
public class Solution {

	public static void main(String[] args) {
		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
	}

	/*
	 * Bucket Sort.
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums.length <= 0 || k <= 0)
			return null;
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		for (int n : nums)
			frequency.put(n, frequency.getOrDefault(n, 0) + 1);
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int key : frequency.keySet()) {
			int f = frequency.get(key);
			if (bucket[f] == null)
				bucket[f] = new ArrayList<Integer>();
			bucket[f].add(key);
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null)
				res.addAll(bucket[i]);
		}
		return res;
	}
}
