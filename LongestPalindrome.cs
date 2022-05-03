using System;
namespace Algorithms
{
    public class LongestPalindrome
    {

        /// Time Complexity : O(n) 
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int longestPalindrome(String s)
        {
            int[] count = new int[128];

            foreach (char c in s.ToCharArray())
                count[c]++;

            int ans = 0;
            foreach (int v in count)
            {
                ans += v / 2 * 2;
                if (ans % 2 == 0 && v % 2 == 1)
                    ans++;
            }
            return ans;
        }
    }
}
