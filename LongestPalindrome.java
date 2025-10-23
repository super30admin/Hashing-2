import java.util.HashSet;

/**
 * 
 */

/**
 * @author Aditya sinha
 *
 */
//we will track char no pair, add 2 to the count and remove, if left add 1 to the total
//Time Complexity ; O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
public class LongestPalindrome {
	public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.size() > 0) return count + 1;
        return count;
    }
}

class LongestPalindromeMain {
	public static void main(String[] args) {
		String s = "abccccdd";
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println("Longest Palindrome- " + lp.longestPalindrome(s));
	}
}