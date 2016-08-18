import java.util.Stack;

/**
 * 
 * @author Demon 2016.8.18
 * 
 *         Reverse a singly linked list.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node = solution.new ListNode(0);
		node.next = solution.new ListNode(1);
		node = solution.reverseList(node);
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		Stack<ListNode> nodes = new Stack<ListNode>();
		while (head != null) {
			nodes.push(head);
			head = head.next;
		}
		head = nodes.pop();
		ListNode tmp = head;
		ListNode next;
		while (!nodes.isEmpty()) {
			next = nodes.pop();
			tmp.next = next;
			tmp = next;
		}
		tmp.next = null;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
