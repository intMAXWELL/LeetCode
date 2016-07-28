import java.util.Stack;


/**
 * 
 * @author Demon 2016.7.28
 * 
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	// DFS
	public TreeNode invertTree(TreeNode root) {
		if(root != null){
			TreeNode tmp = root.right;
			root.right = invertTree(root.left);
			root.left = invertTree(tmp);
			return root;
		} else
			return null;
		
	}
	
	// BFS
	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return null;

		final Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			final TreeNode rootNode = stack.pop();
			TreeNode tmp = rootNode.left;
			rootNode.left = rootNode.right;
			rootNode.right = tmp;
			if (rootNode.left != null)
				stack.push(rootNode.left);
			if (rootNode.right != null)
				stack.push(rootNode.right);
		}
		return root;
	}
	 
	 public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int c) {
			this.val = c;
		}
	 }
	 
}
