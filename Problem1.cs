// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
At first, I put the key-value pair 0,1 in the dictionary as running sum 0 exists in the dictionary once. I iterate through each
element calculating the running sum. If running sum is not present in the dictionary, I put the running sum as key and count of how
many times it has appeared so far as 1. Else I update the count for running sum. I check if dictionary contains rSum - k (We know the 
running sum, we know the value k. So rSum - k would give us the values of elements that sum up to k)
*/


public class Solution
{
    public int SubarraySum(int[] nums, int k)
    {
        int rSum = 0, result = 0;
        Dictionary<int, int> dict = new();
        dict[0] = 1;

        for (int i = 0; i < nums.Length; i++)
        {
            rSum += nums[i];

            if (dict.ContainsKey(rSum - k))
            {
                result += dict[rSum - k];
            }

            if (!dict.ContainsKey(rSum))
            {
                dict[rSum] = 1;
            }

            else
            {
                dict[rSum] += 1;
            }
        }

        return result;
    }
}