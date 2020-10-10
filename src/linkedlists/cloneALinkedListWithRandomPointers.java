package linkedlists;

import java.util.HashMap;
import java.util.Map;

public class cloneALinkedListWithRandomPointers {

	public static Node cloneALinkedList(Node head) {
		Map<Node, Node> nodeMap = new HashMap<>();

		Node curr = head;
		while (curr != null) {
			nodeMap.put(curr, new Node(curr.value));
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			nodeMap.get(curr).next = nodeMap.get(curr.next);
			nodeMap.get(curr).random = nodeMap.get(curr.random);
			curr = curr.next;
		}

		return nodeMap.get(head);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.random = head.next.next;
		head.random.random = head.next.next.next;
		head.random.random.random = head.next;
		System.out.println("=== Original ===");
		System.out.println(head);
		System.out.println("=== Clone ===");
		System.out.println(cloneALinkedList(head));
	}

	private static class Node {
		int value;
		Node next;
		Node random;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node head = this;
			while (head != null) {
				sb.append(head.value);
				if (head.random != null) {
					sb.append(" (random: " + head.random.value + ")");
				}
				sb.append(" -> ");
				head = head.next;
			}
			sb.setLength(sb.length() - 4);
			return sb.toString();
		}
	}
}
