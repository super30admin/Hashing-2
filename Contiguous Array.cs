/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

  Approach: The running sum of the array elements is computed by incrementing the count for 1s and decrementing for 0s. The maximum difference between equal sum index difference is the result.

*/

public class Solution {
    public int FindMaxLength(int[] nums) {
        Dictionary<int,int> dict = new();
        int maxLength = 0;

        int count = 0;
        dict.Add(0,-1);

        for(int i=0;i<nums.Length;i++)
        {
            count+=nums[i]==0?-1:1;
            if(!dict.ContainsKey(count))
            {
                dict.Add(count,i);
            }
            else
            {
                maxLength = Math.Max(maxLength,i-dict[count]);
            }
        }
        return maxLength;
    }
}
