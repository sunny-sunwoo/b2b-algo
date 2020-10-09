package strings;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

	public static List<String> getSubsets(List<String> inputA, List<String> inputB) {
		List<String> output = new ArrayList<>();
		int[] bCounter = makeTable(inputB);

		for (String s : inputA) {
			boolean isSubset = true;
			int[] aCounter = new int[26];
			for (char c : s.toCharArray()) {
				int count = c - 'a';
				aCounter[count]++;
			}
			for (int i = 0; i < 26; i++) {
				if (aCounter[i] < bCounter[i]) {
					isSubset = false;
					break;
				}
			}
			if (isSubset) {
				output.add(s);
			}
		}

		return output;
	}

	private static int[] makeTable(List<String> input) {
		int[] result = new int[26];

		for (String s : input) {
			int[] tmp = new int[26];
			for (char c : s.toCharArray()) {
				int count = c - 'a';
				tmp[count]++;
			}
			for (int i = 0; i < 26; i++) {
				result[i] = Math.max(tmp[i], result[i]);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> inputA = new ArrayList<>();
		List<String> inputB = new ArrayList<>();

		inputA.add("padding");
		inputA.add("css");
		inputA.add("randomcs");

		inputB.add("cs");
		inputB.add("c");

		// Output: ["css", "randomcs"]
		System.out.println(getSubsets(inputA, inputB));
	}

}
