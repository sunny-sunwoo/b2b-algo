package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversalWithoutRecursion {

	public static List<Integer> inorderTraverse(Tree root) {
		List<Integer> result = new ArrayList<>();
		Deque<Tree> stack = new ArrayDeque<>();

		pushLeft(root, stack);

		while (!stack.isEmpty()) {
			Tree curr = stack.removeLast();
			result.add(curr.value);
			if (curr.right != null) {
				pushLeft(curr.right, stack);
			}
		}

		return result;
	}

	private static void pushLeft(Tree curr, Deque<Tree> stack) {
		while (curr != null) {
			stack.addLast(curr);
			curr = curr.left;
		}
		return;
	}

	private static class Tree {
		Tree left;
		Tree right;
		int value;

		public Tree(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Tree root = new Tree(10);
		root.left = new Tree(2);
		root.left.left = new Tree(5);
		root.left.right = new Tree(8);
		root.right = new Tree(4);
		root.right.right = new Tree(44);
		// Output: [5,2,8,10,4,44]
		System.out.println(inorderTraverse(root));
	}

}
