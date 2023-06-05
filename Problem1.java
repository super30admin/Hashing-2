// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the length of the given array

// Your code here along with comments explaining your approach
    //While traversing through the array, we keep track of the running sum, we also maintain a map (key, value) to store the frequencies of the running sums.
    //At every iteration, we look for the frequencies of "runningSum-k" sums in the map.
    //We add up all the "runningSum-k" occurrences.

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int runningSum = 0;
        map.put(runningSum,1);
        for (int x : nums)
        {
            runningSum += x;
            if (map.containsKey(runningSum-k))
            {
                count += map.get(runningSum-k);
            }
            map.put(runningSum, map.getOrDefault(runningSum,0)+1);
        }
        return count;
    }
}