// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : still thinking if we can terminate
//                                          the inner loop and save the sum
//                                        which we are repetitively calculating

class SubArraySumsEqualK
{
  public int subarraySum(int[] nums, int k)
  {
     int sum = 0;
     int count = 0;

     for(int i = 0; i < nums.length; i++)
     {
         sum = nums[i];

         if(sum == k) count++;

         for(int j = i+1; j < nums.length; j++)
         {
             sum += nums[j];

             if(sum == k) count++;
         }
     }

     return count;
   }
}
