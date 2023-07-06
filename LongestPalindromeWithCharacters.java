// Time Complexity : O(n) + O(26) = O(n)
// Space Complexity : O(26) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
class LongestPalindromeWithCharacters {
    public int longestPalindrome(String s) {

        // Create a HashSet to store unique characters
        HashSet<Character> set = new HashSet<>();

        int result = 0; // Variable to store the length of the longest palindrome

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            // If the character is already in the HashSet, it can be used to form a palindrome.
            // Increment the result by 2 to account for both occurrences of the character.
            // Remove the character from the HashSet to indicate its usage.
            if(set.contains(c))
            {
                result += 2;
                set.remove(c);
            }

            // If the character is not in the HashSet, add it to the HashSet.
            else
            {
                set.add(c);
            }
        }

        // If there are any remaining characters in the HashSet,
        // it means they can be used as a middle character in the palindrome.
        // Increment the result by 1.
        if(!set.isEmpty())
        {
            result++;
        }

        return result; // Return the length of the longest palindrome

    }
}