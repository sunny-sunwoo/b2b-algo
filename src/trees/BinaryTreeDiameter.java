package trees;

public class BinaryTreeDiameter {

	public static int getDiameter(Tree root) {
		return getMaxHeight(root).maxHeight;
	}

	private static DepthData getMaxHeight(Tree root) {
		// base case
		if (root == null) {
			return new DepthData(0, 0);
		}

		DepthData leftDepth = getMaxHeight(root.left);
		DepthData rightDepth = getMaxHeight(root.right);

		int maxOfChild = Math.max(leftDepth.maxHeight, rightDepth.maxHeight);
		int longestChild = Math.max(leftDepth.longestChild, rightDepth.longestChild);

		int maxHeight = Math.max(maxOfChild, leftDepth.longestChild + rightDepth.longestChild);

		return new DepthData(maxHeight, longestChild + 1);
	}

	private static class DepthData {
		int maxHeight;;
		int longestChild;
		
		public DepthData(int maxHeight, int longestChild) {
			this.maxHeight = maxHeight;
			this.longestChild = longestChild;
		}
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
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.right.left = new Tree(4);
		root.right.right = new Tree(5);
		root.right.left.left = new Tree(6);
		root.right.right.left = new Tree(7);
		root.right.right.right = new Tree(8);
		root.right.left.left.right = new Tree(9);
		// Output: 5
		System.out.println(getDiameter(root));

		Tree root2 = new Tree(1);
		root2.left = new Tree(2);
		// Output: 1
		System.out.println(getDiameter(root2));
	}

}
