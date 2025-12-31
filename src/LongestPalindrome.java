/*
Problem - Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
We use a HashSet to track characters that haven't formed a pair yet.
When we find a pair, we add 2 to the count and remove that char from the set.
If anything is left in the set, we can put one in the center — so we add 1 to the total.
Time Complexity - O(n)
Space Complexity - O(1)
 */


import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for ( char c : s.toCharArray() ) {
            // if the character is already present in the set make it pair by increasing the counter and remove mapping
            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            }
            // if not present in the set add it
            else {
                set.add(c);
            }
        }
        if (set.size() > 0) return count + 1;
        return count;
    }
}
