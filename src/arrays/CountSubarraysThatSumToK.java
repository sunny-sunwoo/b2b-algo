package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysThatSumToK {
	public static int countSubarrays(int[] input, int k) {
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return count;
	}
	public static void main(String[] args) {
		int[] input = {1, 0, -1, 1};
		int k = 0;
		// output: 4
		System.out.println(countSubarrays(input, k));
	}
}
