public class LongestPalindrome
    {
        /* Approach: 
         * Go over each character in the string
         * Check if character exists in the Hashset.If exists, increase the count by 2 and remove from the Hashset. If not exists, then add to hashset
         * If hash set is not empty at the end, then add 1 to the count
         * */

        // Time Complexity : O(n) -- since we are going over the entire string
        // Space Complexity : O(1) -- since the max value in hashset can be 26 keys
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int LongestPalindrome1(string s)
        {
            HashSet<char> set = new HashSet<char>();
            char[] sArr = s.ToCharArray();
            int count = 0;
            for (int i = 0; i < sArr.Length; i++)
            {
                if (set.Contains(sArr[i]))
                {
                    count = count + 2;
                    set.Remove(sArr[i]);
                }
                else
                {
                    set.Add(sArr[i]);
                }
            }
            if (set.Count != 0)
                count = count + 1;

            return count;
        }
    }
