/**
 * 
 * @author Demon 2016.8.2
 * 
 *         Given a binary tree containing digits from 0-9 only, each
 *         root-to-leaf path could represent a number.
 * 
 *         An example is the root-to-leaf path 1->2->3 which represents the
 *         number 123.
 * 
 *         Find the total sum of all root-to-leaf numbers.
 * 
 *         For example,
 * 
 *          1 
 *         / \ 
 *        2   3
 * 
 *         The root-to-leaf path 1->2 represents the number 12. The root-to-leaf
 *         path 1->3 represents the number 13.
 * 
 *         Return the sum = 12 + 13 = 25.
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	// DFS
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.val;
		return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
