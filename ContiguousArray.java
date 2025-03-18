
// Time Complexity : O(N) where N is the length of the array
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The approach uses a HashMap to store the first occurrence of a running sum.
// We update the sum as +1 for '1' and -1 for '0' and check if the sum has been seen before.
// If the sum is 0, the subarray from the start has equal 0s and 1s.
// Otherwise, the difference between the current index and the stored index gives the longest subarray.

import java.util.*;

class ContiguousArray{
    public int findMaxLength(int[] nums) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int op = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                sum = sum+1;
            }
            else
            {
                sum = sum-1;
            }
            if(sum == 0)
            {
                op = Math.max((i+1),op);
            }
            else if(map.containsKey(sum))
            {
                int get = map.get(sum);
                int len = i-get;
                op = Math.max(len,op);
            }
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }
        }
        return op;
    }
}