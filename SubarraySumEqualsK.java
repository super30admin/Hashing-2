// Time Complexity : O(N) where N is the length of the array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:

// The approach uses a HashMap to store prefix sum frequencies.
// The running sum is computed iteratively, and we check if (sum - k) exists in the map.
// If it does, it means there exists a subarray that sums to k, so we add its frequency to the count.
// Additionally, if sum == k at any index, we increment the count, as the entire subarray from index 0 contributes to k.
// The current sum is stored in the HashMap to track occurrences for future subarrays.


import java.util.*;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) 
    {
        int sum = 0; 
        int op =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++)
        {
            sum = sum+nums[i];
            int rem = sum-k;
            if(rem == 0)
            {
                op= op+1;
            }
            if(map.containsKey(rem))
            {
                int get = map.get(rem);
                op = op+get;
            }
            if(map.containsKey(sum))
            {
                int get = map.get(sum);
                map.put(sum,get+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return op;

    }
}