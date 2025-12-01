import java.util.Map;
import java.util.HashMap;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, i has to refer to online resources to understand the hashmap approach


// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        // running sum array
        // map to store freq of running sum
        // iterate nums and running sum array and 
        // a. if runningsum[i] == k, result++
        // b. find tempsum = runningsum[i] - num[i]
        //    if tempsum is in map then result += map.get(runningsum)

        int[] runningsums = new int[nums.length];
        runningsums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            runningsums[i] = runningsums[i-1]+nums[i];
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(runningsums[i] == k)
            {
                result++;
            }
            int diff = runningsums[i] - k;
            if(map.containsKey(diff))
            {
                result += map.get(diff);
            }
            map.put(runningsums[i], map.getOrDefault(runningsums[i], 0) + 1);
        }

        return result;
    }
}
