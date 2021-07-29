// Time Complexity : O(N), where N = length of array
// Space Complexity : O(N).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store first index this sum has occured
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        // '0' can be obtained from empty array as well, so 0's default index is -1
        sumToIndexMap.put(0, -1);
        int rSum = 0, len = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++)
        {
            // if it is 1 add 1; or else if it is 0 add -1.
            rSum += nums[i] == 1 ? 1 : -1;

            // check if Running sum was already in map
            // if it was that means this is balanced Subarray from prevIndex till this
            if(sumToIndexMap.containsKey(rSum))
            {
                len = i - sumToIndexMap.get(rSum);
                maxLen = Math.max(len, maxLen);
            }
            else
            {
                // update map
                sumToIndexMap.put(rSum, i);
            }
        }
        
        return maxLen;
    }
}