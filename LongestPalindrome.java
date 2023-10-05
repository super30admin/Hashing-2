/* Time Complexity : O(n)
 * 	n - length of the input string, as we have to traverse through it*/
/* Space Complexity : O(52) ~ O(1) - as input can contain only lower and upper case English letters */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*Logic: 
 * Initialize count to '0' and a HashSet. Traverse through the input string. 
 * If char is present in set, increment count by 2 and remove that char from the set
 * else add char to the set
 * After traversing, if the set still has values left in it, increment count by 1. 
 * Final count holds the length of the longest Palindrome */ 
import java.util.HashSet;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return -1;

		HashSet<Character> charSet = new HashSet<>();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet.contains(c)) {
				count += 2;
				charSet.remove(c);
			} else {
				charSet.add(c);
			}
		}
		if (!charSet.isEmpty())
			count += 1;

		return count;
	}

}
