import java.util.LinkedList;

/**
 * 
 * @author Demon 2016.8.20
 * 
 *         Given a sorted linked list, delete all duplicates such that each
 *         element appear only once.
 * 
 *         For example,
 * 
 *         Given 1->1->2, return 1->2.
 * 
 *         Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = solution.new ListNode(1);
		head.next = solution.new ListNode(1);
		head.next.next = solution.new ListNode(2);
		head = solution.deleteDuplicates(head);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		int current = head.val;
		ListNode pre = head;
		ListNode tmp = head.next;
		while (tmp != null) {
			if (tmp.val == current) { // Delete duplicates
				pre.next = tmp.next;
				tmp = pre.next;
			} else {
				pre = pre.next;
				tmp = tmp.next;
				current = pre.val;
			}
		}
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
