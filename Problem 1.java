// https://leetcode.com/problems/subarray-sum-equals-k/description/

// Time Complexity : O(n), we go over input once
// Space Complexity : O(n), we use a map to maintain running sums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We are going to use the pattern "Running Sums"
// There is a nested iteration which we can eliminate using running sum

import java.util.HashMap;
import java.util.Map;

class Problem3 {
    public int subarraySum(int[] nums, int k) {
      // Mapping bw running sum and the frequency
        Map<Integer, Integer> sumMap=new HashMap<>();

        // Add dummy entry for edge case as initial running sum is zero
        // and we have already encountered it in empty array
        sumMap.put(0, 1);

        int count=0;
        int runningSum=0;

        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];

            if(sumMap.containsKey(runningSum-k)){
                // We have a running sum which is k less than current running sum
                // This means there is a sub-array in between with sum k
                // Get and update count
                count+=sumMap.get(runningSum-k);
            }
            
            // Update value of current running sum
            if(!sumMap.containsKey(runningSum)) sumMap.put(runningSum,1);
            else    sumMap.put(runningSum, sumMap.get(runningSum)+1); 
        }

        return count;  
    }
}
