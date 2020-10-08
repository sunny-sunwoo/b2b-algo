package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * q. Given a string s, return the length of the longest substring of s without repeating characters.
 * sol. sliding window approach
 * - with caching prev idx in hashmap
 * -> t.c O(n)
 * @author sunnypark
 *
 */
public class LongestSubstringWoRepeatingChars {
	public static int longestUniqueCharacterSubstring(String input) {
		int left = 0;
		int right = 0;
		
		int maxLen = 0;
		Map<Character, Integer> cache = new HashMap<>();
		
		while (right < input.length()) {
			char currChar = input.charAt(right);
			if (cache.containsKey(currChar)) {
				maxLen = Math.max(maxLen, right - left + 1);
				left = cache.get(currChar) + 1;
			}
			cache.put(currChar, right);
			right++;
		}

		return maxLen;
	}
	
	public static void main(String[] args) {
		System.out.println(longestUniqueCharacterSubstring("ABCABADEC"));
	}
}
