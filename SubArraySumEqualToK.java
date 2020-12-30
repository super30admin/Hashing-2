// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Did it run successfully on Leetcode? YES
class Solution {
    public int subarraySum(int[] nums, int k) {
      int count = 0;
      for (int i = 0; i < nums.length; i++)
      {
          int sum = 0;
          for (int j = i; j < nums.length; j++)
          {
              sum = sum + nums[j];
              if ( sum == k)
                  count++;
          }
      }
    return count;
    }
}
