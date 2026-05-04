// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution
{
    public int FindMaxLength(int[] nums)
    {
        Dictionary<int, int> dict = new();

        int maxLength = 0;

        int rSum = 0;

        dict[0] = -1;

        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] == 0)
            {
                rSum -= 1;
            }

            else
            {
                rSum += 1;
            }

            if (!dict.ContainsKey(rSum))
            {
                dict[rSum] = i;
            }

            else
            {
                maxLength = Math.Max(i - dict[rSum], maxLength);
            }

        }

        return maxLength;
    }
}