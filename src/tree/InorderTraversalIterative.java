package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversalIterative {
	public static List<Integer> traverse(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		pushLeft(stack, root);
		
		while (!stack.isEmpty()) {
			TreeNode curr = stack.removeLast();
			result.add(curr.val);
			if(curr.right != null) {
				pushLeft(stack, curr.right);
			}
		}

		return result;
	}
	
	private static void pushLeft(Deque<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.addLast(node);
			node = node.left;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(traverse(TreeNode.generate()));
	}
}

