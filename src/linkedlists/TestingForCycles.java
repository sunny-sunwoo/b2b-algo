package linkedlists;

public class TestingForCycles {

	public static boolean checkCycle(ListNode head) {
		ListNode walker = head;
		ListNode runner = head;
		while (runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next.next;
		System.out.println(checkCycle(head));
		// true

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(5);
		System.out.println(checkCycle(head2));
		// false
	}

	private static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
