// Time Complexity : O(n) number of characters in string
// Space Complexity : O(1) - only uppercase and lowercase characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We utilize a HashSet to store unique characters and iterates through each character to identify palindrome pairs.
If the string is not empty, it accounts for a single character that cannot form a pair within the palindrome.
 */
import java.util.HashSet;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        if (s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (Character ch : s.toCharArray()) {
            if (set.contains(ch)) {
                len += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (!s.isEmpty()) {
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
