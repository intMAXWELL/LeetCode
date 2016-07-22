/**
 * 
 */

/**
 * @author Demon 2016.7.22
 * 
 *         Given a binary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	// DFS
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(root.left == null ? 1 : 1 + maxDepth(root.left),
				root.right == null ? 1 : 1 + maxDepth(root.right));
	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}
}
