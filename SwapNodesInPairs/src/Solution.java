/**
 * 
 * @author Demon 2016.8.10
 * 
 *         Given a linked list, swap every two adjacent nodes and return its
 *         head.
 * 
 *         For example, Given 1->2->3->4, you should return the list as
 *         2->1->4->3.
 * 
 *         Your algorithm should use only constant space. You may not modify the
 *         values in the list, only nodes itself can be changed.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node = solution.new ListNode(0), head = node;
		for (int i = 1; i <= 5; i++) {
			ListNode node2 = solution.new ListNode(i);
			node.next = node2;
			node = node2;
		}
		printList(head);
		printList(solution.swapPairs(head));
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// Swap head
		ListNode newHead = head.next;
		head.next = newHead.next;
		newHead.next = head;

		ListNode cursor = head.next, pre = head, tmp = null;
		while (cursor != null && cursor.next != null) {
			tmp = cursor.next;
			cursor.next = tmp.next;
			pre.next = tmp;
			tmp.next = cursor;
			pre = cursor;
			cursor = cursor.next;
		}
		return newHead;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println();
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
