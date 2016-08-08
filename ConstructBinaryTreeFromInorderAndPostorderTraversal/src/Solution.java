/**
 * 
 * @author Demon 2016.8.8
 * 
 *         Given inorder and postorder traversal of a tree, construct the binary
 *         tree.
 * 
 *         Note: You may assume that duplicates do not exist in the tree.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] in = { 1, 2, 3, 4, 5, 6 };
		int[] post = { 1, 3, 2, 6, 5, 4 };
		TreeNode node = solution.buildTree(in, post);
		preorder(node);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0 || postorder.length != inorder.length)
			return null;
		return build(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	public TreeNode build(int[] inorder, int[] postorder, int inStart,
			int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		TreeNode node = new TreeNode(postorder[postEnd]);
		if (inStart == inEnd || postEnd == postStart)
			return node;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				node.left = build(inorder, postorder, inStart, i - 1,
						postStart, postStart + i - 1 - inStart);
				node.right = build(inorder, postorder, i + 1, inEnd, postStart
						+ i - inStart, postEnd - 1);
				break;
			}
		}
		return node;
	}

	public static void preorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + ",");
		if (node.left != null)
			preorder(node.left);
		if (node.right != null)
			preorder(node.right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}
}
