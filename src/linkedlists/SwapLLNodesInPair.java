package linkedlists;

/**
 * q. Given a singly linked list, reorder its nodes such that pairs of consecutive nodes are interchanged. 
 * sol. recursive approach
 * 
 *          a -> b -> c -> d -> e -> x
 *  null <- a <- b
 *              prev
 *             
 *             null <- c <- d
 *                         prev
 *                         
 *                         null <- e
 *  							  prev 
 *  
 *  => head.next = swap(curr);
 *  
 * @author sunnypark
 *
 */
public class SwapLLNodesInPair {
	public static ListNode swapInPair(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		int cnt = 0;
		
		while (curr != null && cnt < 2) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt++;
		}
		
		if (curr != null) {
			head.next = swapInPair(curr);
		}

		return prev;
	}

	private class ListNode {
		int val;
		ListNode next;
	}

}
