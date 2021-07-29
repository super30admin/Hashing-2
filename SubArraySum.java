// Time Complexity : O(N), where N = length of array
// Space Complexity : O(N).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store How many times this sum has occured
        Map<Integer, Integer> sumCounterMap = new HashMap<>();
        
        // '0' can be obtained from empty array as well, so 0's default count is 1
        sumCounterMap.put(0, 1);
        int rSum = 0, count = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            rSum += nums[i];
            // check if Running sum - k was already in map
            // if it was that means k can be obtained as Subarray from prevIndex till this
            if(sumCounterMap.containsKey(rSum - k))
            {
                // Increase count
                count += sumCounterMap.get(rSum - k);
            }
            // Update Map 
            sumCounterMap.put(rSum, sumCounterMap.getOrDefault(rSum , 0) + 1);
        }
        
        return count;
    }
}