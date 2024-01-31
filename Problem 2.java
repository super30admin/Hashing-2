// https://leetcode.com/problems/contiguous-array/

// Time Complexity : O(n), we go over input once
// Space Complexity : O(n), we use a map to maintain running sums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// We are going to use the pattern "Running Sums"
// There is a nested iteration which we can eliminate using running sum
// Running Sum logic here: Inc sum by 1 when encountering a 1, dec by 1 on encountering a 0
// If we encounter same runningSum, this means that subarray bw the positions is balanced

// O(n) time complexity , O(n) space complexity used by map

import java.util.HashMap;
import java.util.Map;

class Problem2 {
    public int findMaxLength(int[] nums) {
        // Mapping bw running sum and the earliest index we encountered it
        Map<Integer, Integer> sumMap=new HashMap<>();

        // Add dummy entry for edge case as initial running sum is zero
        // and we have already encountered it in empty array
        sumMap.put(0, -1);

        int maxLen=0;
        int runningSum=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)  runningSum++;
            else    runningSum--;

            if(sumMap.containsKey(runningSum)){
                // Already seen this running sum, we have a balanced subarray
                // Get and update length
                maxLen=Math.max(maxLen, i-sumMap.get(runningSum));
            }else{
                // Add entry to map
                sumMap.put(runningSum, i);
            }
        }

        return maxLen;
    }
}