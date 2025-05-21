/*
  Time complexity: O(n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

  Approach: The running sum of the elements in the nums array is computed. The sum-k is compared to the previous sums to check is it has occurred. The result is incremented by the frequency of that occurrence. 

*/

public class Solution {
    public int SubarraySum(int[] nums, int k) {
        int sum = 0;
        Dictionary<int,int> dict = new();
        int count = 0;
        dict.Add(0,1);
        for(int i=0;i<nums.Length;i++)
        {
            sum = sum+nums[i];
            if(dict.ContainsKey(sum-k))
                count+=dict[sum-k];
            
            if(!dict.ContainsKey(sum))
                dict.Add(sum,1);
            else
                dict[sum]+=1;
        }
        return count;
    }
}

//1,1,1.  sum=1 sum-k=1
