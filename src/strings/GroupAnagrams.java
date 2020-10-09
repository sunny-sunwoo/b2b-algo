package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(List<String> input) {
		Map<String, List<String>> anagramMap = new HashMap<>();

		for (String s : input) {
			String code = getCode(s);
			List<String> anagramLists = anagramMap.getOrDefault(code, new ArrayList<>());
			anagramLists.add(s);
			anagramMap.put(code, anagramLists);
		}

		return new ArrayList<>(anagramMap.values());
	}

	private static String getCode(String s) {
		StringBuilder sb = new StringBuilder();
		int[] tmp = new int[26];
		for (char c : s.toCharArray()) {
			int count = c - 'a';
			tmp[count]++;
		}
		for (int i = 0; i < 26; i++) {
			sb.append(tmp[i] + ",");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("eat");
		input.add("bat");
		input.add("ate");
		input.add("tab");
		input.add("tea");
		input.add("eat");
		// Output:
		// [
		// 	["eat", "ate", "tea", "eat"],
		//  ["bat", "tab"]
		// ]
		System.out.println(groupAnagrams(input));
	}
}
