package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalofAMatrix {

	public static List<Integer> spiralTraverse(int[][] input) {
		List<Integer> output = new ArrayList<>();

		int topFence = 0;
		int leftFence = 0;
		int bottomFence = input.length - 1;
		int rightFence = input[0].length - 1;

		while (topFence <= bottomFence && leftFence <= rightFence) {
			// walk top fence
			for (int col = leftFence; col <= rightFence; col++) {
				output.add(input[topFence][col]);
			}
			topFence++;

			// walk right fence
			for (int row = topFence; row <= bottomFence; row++) {
				output.add(input[row][rightFence]);
			}
			rightFence--;

			// walk bottom fence
			if (topFence <= bottomFence) {
				for (int col = rightFence; col >= leftFence; col--) {
					output.add(input[bottomFence][col]);
				}
				bottomFence--;
			}

			// walk left fence
			if (leftFence <= rightFence) {
				for (int row = bottomFence; row >= topFence; row--) {
					output.add(input[row][leftFence]);
				}
			}
			leftFence++;
		}

		return output;
	}

	public static void main(String[] args) {
		int[][] input = {
				{1, 2, 3}, 
				{4, 5, 6}, 
				{7, 8, 9}
		};
		// Output: [1,2,3,6,9,8,7,4,5]
		System.out.println(spiralTraverse(input));

		int[][] input2 = {
				{1,2,3,4}, 
				{5,6,7,8}
		};
		// Output: [1,2,3,4,8,7,6,5]
		System.out.println(spiralTraverse(input2));
	}

}
