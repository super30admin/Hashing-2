// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.HashSet;
import java.util.Set;

/**
 * Take a set and put each char iterating over the string.
 * If a char is repeated, then increment count by 2 and remove it from
 * the set. After all chars are read, check if the set is empty or not,
 * if not increment count by 1. Return count.
 *
 */
public class LongestPalindromicSubstring {
	public int longestPalindrome(String s) {
		if (s.length() == 1)
			return 1;
		int count = 0;
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				count += 2;
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		if (set.size() != 0)
			count++;
		return count;
	}
}
