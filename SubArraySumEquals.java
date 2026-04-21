// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This code tracks a running total resultSum of the array elements as it iterates and uses a HashMap to store how many times each prefix sum has occurred.
// If resultSum - k exists in the map, it means a subarray summing to k was just completed, so it adds that frequency to the total count.

import java.util.HashMap;
import java.util.Map;

class SubArraySumEquals {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int count = 0;
        int resultSum = 0;

        for (int i=0; i<nums.length; i++) {
            resultSum += nums[i];
            if (hashMap.containsKey(resultSum-k)) {
                count += hashMap.get(resultSum-k);
            } 
            hashMap.put(resultSum, hashMap.getOrDefault(resultSum, 0) + 1);
        }
        return count;
    }
}