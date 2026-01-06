// Time Complexity: O(n)
// Space Complexity: O(n)


// Treat 0 as -1 and 1 as +1, and maintain a running sum; equal numbers of 0s and 1s result in the same prefix sum repeating.
// Use a dictionary to store the first index where each prefix sum occurs (initialize sum = 0 at index -1).
// When the same sum appears again, the subarray between the previous index and current index has equal 0s and 1s; 
// update the maximum length.
public class Solution
{
    public int FindMaxLength(int[] nums)
    {
        if (nums == null || nums.Length == 0)
            return 0;
        Dictionary<int, int> dict = new();
        int max = 0; int sum = 0;
        dict.Add(0, -1);
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] == 0)
                sum -= 1;
            else
                sum += 1;

            if (dict.ContainsKey(sum))
            {
                int currentIndex = i - dict[sum];
                max = Math.Max(max, currentIndex);
                // if you need  maintain indexes
                // if (max < currentIndex)
                // {
                //     int start = dict[sum] + 1;
                //     int end = i;
                // }
            }
            else
            {
                dict.Add(sum, i);
            }
        }
        return max;
    }
}