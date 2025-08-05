// Time Complexity : O(n), where n is the length of the string
// Space Complexity : O(1), because there are only 52 possible characters (upper & lowercase)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :
// I used a HashSet to track characters that appear an odd number of times.
// If a character is already in the set, we remove it and add 2 to the count (one pair formed).
// If not, we add it to the set.
// At the end, if the set is not empty, it means we can place one character with odd frequency in the center.
// So we return count + 1 if set is not empty, else just return count.

import java.util.*;

public class LongestPalindrome 
{
    public int longestPalindrome(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray())
        {
            if (set.contains(c))
            {
                set.remove(c); // pair complete
                count += 2;
            }
            else
            {
                set.add(c); // seen once
            }
        }

        // If there's at least one character with odd frequency, place it in the center
        if (set.size() > 0) return count + 1;

        return count;
    }
}
