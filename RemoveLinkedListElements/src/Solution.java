/**
 * 
 * @author Demon 2016.8.4
 * 
 *         Remove all elements from a linked list of integers that have value
 *         val.
 * 
 *         Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return:
 *         1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = solution.new ListNode(6);
		head.next = solution.new ListNode(5);
		solution.removeElements(head, 5).printList();
	}

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

		public void printList() {
			System.out.print(val + "->");
			ListNode tmp = next;
			while (tmp != null) {
				System.out.print(tmp.val + "->");
				tmp = tmp.next;
			}
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode tmp; // Record head.
		// Determine Head
		while (head != null && head.val == val) {
			tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}

		if (head == null || head.next == null)
			return head;

		// Remove ListNode
		tmp = head.next;
		ListNode pre = head;
		while (tmp != null) {
			if (tmp.val == val) {
				pre.next = tmp.next;
				tmp.next = null;
				tmp = pre.next;
			} else {
				pre = tmp;
				tmp = tmp.next;
			}
		}
		return head;
	}
}
