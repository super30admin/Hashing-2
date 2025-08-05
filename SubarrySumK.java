// Time Complexity : O(n), where n is the length of the input array
// Space Complexity : O(n), for storing the running sum frequencies in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :
// I used a HashMap to store frequencies of running sums (prefix sums).
// At each index, we compute the running sum so far.
// If runningSum - k has been seen before, it means there exists a subarray that sums to k.
// There are two approaches shown:
// 1. Using map.put(0,1) initially and skipping complement==0 check.
// 2. Or not using map.put(0,1) but checking if complement == 0 explicitly. 

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int runningSum = 0;

        // map.put(0,1); // Alternate approach: allows skipping complement == 0 check

        for (int i = 0; i < nums.length; i++)
        {
            runningSum += nums[i];

            int complement = runningSum - k;

            // Needed only if not using map.put(0,1)
            if (complement == 0) count++;

            if (map.containsKey(complement))
            {
                count += map.get(complement);
            }

            // map.put(runningSum, map.getOrDefault(runningSum, 0) + 1); // shorter version

            if (map.containsKey(runningSum))
            {
                map.put(runningSum, map.get(runningSum) + 1);
            }
            else
            {
                map.put(runningSum, 1);
            }
        }

        return count;
    }
}
