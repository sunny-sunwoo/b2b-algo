package tree;

public class BTDiameter {
	public static int findDiameter(TreeNode root) {
		return find(root).diameter;
	}
	
	private static Data find(TreeNode node) {
		if (node == null) {
			return new Data(0, 0);
		}
		
		Data left = find(node.left);
		Data right = find(node.right);
		
		int maxFromLR = Math.max(left.diameter, right.diameter);

		int bestDiameter = Math.max(maxFromLR, left.height + right.height);
		int currHeight = Math.max(left.height, right.height) + 1;
		
		return new Data(currHeight, bestDiameter);
	}
	
	private static class Data {
		int height;
		int diameter;
		
		public Data(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	public static void main(String[] args) {
		System.out.println(findDiameter(TreeNode.generate()));
	}
}
