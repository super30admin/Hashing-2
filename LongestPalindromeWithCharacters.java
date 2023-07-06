// Time Complexity : O(n) + O(26) = O(n)
// Space Complexity : O(26) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
class LongestPalindromeWithCharacters {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();

        int result = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(set.contains(c))
            {
                result += 2;
                set.remove(c);
            }

            else
            {
                set.add(c);
            }
        }

        if(!set.isEmpty())
        {
            result++;
        }

        return result;

    }
}