// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution
{
    public int LongestPalindrome(string s)
    {
        HashSet<char> set = new();
        int result = 0;
        for (int i = 0; i < s.Length; i++)
        {
            if (set.Contains(s[i]))
            {
                result += 2;
                set.Remove(s[i]);
            }

            else
            {
                set.Add(s[i]);
            }
        }

        if (set.Count != 0)
        {
            result += 1;
        }

        return result;
    }

}