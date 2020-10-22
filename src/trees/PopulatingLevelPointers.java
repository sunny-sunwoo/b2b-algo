package trees;

public class PopulatingLevelPointers {

	public static TreeNode populateLevelPointers(TreeNode node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			if (node.right != null) {
				node.left.next = node.right;
			} else {
				node.left.next = findNext(node.next);
			}
		}

		if (node.right != null) {
			node.right.next = findNext(node.next);
		}

		populateLevelPointers(node.left);
		populateLevelPointers(node.right);

		return node;
	}

	private static TreeNode findNext(TreeNode node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			return node.left;
		}
		if (node.right != null) {
			return node.right;
		}
		return findNext(node.next);
	}

	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		public TreeNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			TreeNode curr = this;
			StringBuilder sb = new StringBuilder();
			inorderTraverse(curr, sb);

			return sb.toString();
		}

		private static void inorderTraverse(TreeNode curr, StringBuilder sb) {
			if (curr == null) {
				return;
			}
			inorderTraverse(curr.left, sb); 
			sb.append(curr.value);
			if (curr.next == null) {
				sb.append("->X ");
			} else {
				sb.append("->" + curr.next.value + " ");
			}
			inorderTraverse(curr.right, sb);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.right.right.right = new TreeNode(15);
		System.out.println(populateLevelPointers(root));
	}

}
