// Time Complexity: O(n)
// Space Complexity: O(n)

// Use a prefix sum (rsum) and a dictionary to store how many times each prefix sum has appeared.
// For each index, check if (rsum − k) exists in the dictionary; if it does, those occurrences form subarrays with sum k.
// Update the dictionary with the current prefix sum count as you iterate.
public class Solution
{
    public int SubarraySum(int[] nums, int k)
    {
        Dictionary<int, int> dict = new();
        int rsum = 0;
        int count = 0;
        dict.Add(0, 1);
        for (int i = 0; i < nums.Length; i++)
        {
            rsum += nums[i];
            int res = rsum - k;
            if (dict.ContainsKey(res))
            {
                count += dict[res];
            }
            if (dict.ContainsKey(rsum))
            {
                dict[rsum]++;
            }
            else
            {
                dict.TryAdd(rsum, 1);
            }
        }
        return count;

    }
}
