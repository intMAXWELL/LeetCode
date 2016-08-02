/**
 * 
 * @author Demon 2016.8.2
 * 
 *         The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 *         By listing and labeling all of the permutations in order, We get the
 *         following sequence (ie, for n = 3):
 * 
 *         "123" "132" "213" "231" "312" "321" Given n and k, return the kth
 *         permutation sequence.
 * 
 *         Note: Given n will be between 1 and 9 inclusive.
 *
 */
public class Solution {
	public static void main(String[] arg) {
		Solution solution = new Solution();
		System.out.println(solution.getPermutation(9, 1));
	}

	// List all permutation nums
	static int[] fullPermutation = { 1, 2, 6, 24, 120, 720, 5040, 40320 };

	/*
	 * The main idea is C(n, k) = I + C (n - 1, k') using loops.
	 * 
	 * It costs only 2ms, and beats 73.96% of javasubmissions.
	 * 
	 * For example, if we want to compute C(3, 5), which means n = 3 and k = 5,
	 * we should return the 5th permutation sequence.
	 * 
	 * First, we should determine the first number, just as the I in formula. We
	 * know we have 6 cases in total when n = 3. If you were to list out all the
	 * permutations you have:
	 * 
	 * 1 + (permutations of 2, 3)
	 * 
	 * 2 + (permutations of 1, 3)
	 * 
	 * 3 + (permutations of 1, 2)
	 * 
	 * So if you were to look for the (k = 5) 5th permutation, it would be in
	 * the
	 * 
	 * 2 + (permutations of 1, 3) subset.
	 * 
	 * So I = 2(5/2), the second digit.
	 * 
	 * Next Step: we compute C(n-1, k'), k' = 1(5%2), which means, the first
	 * permutation of (permutations of 1, 3)
	 * 
	 * Special cases and Exit: When k' = 0, which means, the last permutation of
	 * sub-permutation. We can simply print the unused digit in order.
	 * 
	 * For example:
	 * 
	 * Input n = 3 and k = 5; Initialize output s = "";
	 * 
	 * Compute C(3, 5), I = 5/2 = 2, k' = 5%2 = 1, s = "3";
	 * 
	 * Compute C(2, 1), I = 1/1 = 1, k' = 1%1 = 0, s = "31" ,since k' = 0, we
	 * just print unused digit in order, s = "31" + "2" = "312";
	 * 
	 * Input n = 9 and k = 1; Initialize output s = "";
	 * 
	 * Compute C(9, 1), I = 1/40320 = 0, k' = 1, s = "1";
	 * 
	 * Compute C(8, 1), I = 1/5040 = 0, k' = 1, s = "12";
	 * 
	 * ...
	 * 
	 * Compute C(a, 1), I = 1/fullPermutation[a-2] = 0, k' = 1, s="123.."
	 * 
	 * Compute C(2, 1), I = 1/1 = 1, k' = 1%1 = 0, s = "1234567" + "8" =
	 * "12345678",since k' = 0, we just print unused digit in order, s =
	 * "12345678" + "9" = "123456789";
	 */
	public String getPermutation(int n, int k) {
		if (n == 1)
			return "1";
		boolean[] used = new boolean[n];
		String s = "";
		int a = 0;
		for (; n > 1; n--) {
			a = k / fullPermutation[n - 2];
			k = k % fullPermutation[n - 2];
			if (k == 0) {
				int b = getKthUnusedNum(used, a);
				s += b;
				used[b - 1] = true;
				for (n = used.length; n > 0; n--) {
					if (!used[n - 1])
						s += n;
				}
			} else {
				int b = getKthUnusedNum(used, a + 1);
				s += b;
				used[b - 1] = true;
			}
		}
		return s;
	}

	public int getKthUnusedNum(boolean[] used, int k) {
		int i = 0;
		while (k > 0) {
			if (!used[i])
				k--;
			i++;
		}
		return i;
	}
}
