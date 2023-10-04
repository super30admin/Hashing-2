public class Solution
    {
        // Time Complexity : O(n) -- since we are going over the entire array
        // Space Complexity : O(n) 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int FindMaxLength(int[] nums)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            map.Add(0, -1);

            int runningSum = 0;
            int maxLength = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] == 1)
                    runningSum = runningSum - 1;
                else
                    runningSum = runningSum + 1;

                if (map.ContainsKey(runningSum))
                {
                    maxLength = Math.Max(i - map[runningSum], maxLength);
                }
                else
                {
                    map.Add(runningSum, i);
                }
            }
            return maxLength;
        }
    }
