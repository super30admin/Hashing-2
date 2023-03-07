import java.util.Set;
import java.util.HashSet;

// Time Complexity: O(n); n = s.length()
// Space Complexity: O(n)
// Did this code run on leetcode? : Yes
class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        Set<Character> seen = new HashSet<>();

        for(char c : s.toCharArray()) {
            // If I've seen this character before, I found a pair
            // which I can use to form a palindrome
            if(seen.contains(c)) {
                count += 2;

                // Remove since I used this pair
                seen.remove(c);
            } else {
                // Mark this character as seen
                seen.add(c);
            }
        }

        // If set is not empty, we can use at-least one of the characters as 
        // the middle element of any palindrome we would form.
        return count + (seen.isEmpty() ? 0 : 1);
    }
}