package trees;

public class TestIfABinaryTreeIsHeightBalanced {

	public static boolean isBalanced(TreeNode root) {
		return getData(root).balance;
	}

	private static Data getData(TreeNode node) {
		if (node == null) {
			return new Data(true, -1);
		}

		Data leftData = getData(node.left);
		if (leftData.balance == false) {
			return leftData;
		}

		Data rightData = getData(node.right);
		if (rightData.balance = false) {
			return rightData;
		}

		boolean balance = Math.abs(leftData.height - rightData.height) <= 1;
		int height = Math.max(leftData.height, rightData.height) + 1;

		return new Data(balance, height);
	}

	private static class Data {
		boolean balance;
		int height;

		public Data(boolean balance, int height) {
			this.balance = balance;
			this.height = height;
		}
	}

	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(isBalanced(root));
		// Output: true

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(5);
		root2.right.right.right = new TreeNode(6);
		System.out.println(isBalanced(root2));
		// Output: false
	}

}
