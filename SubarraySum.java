// https://leetcode.com/problems/subarray-sum-equals-k
// Approach: Running sum pattern
// Time complexity: O(N)
// Space complexity: O(N) for sumMap.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // counts number of occurrences of sum k
        int runningSum = 0; // updates sum at each index
        // Store running sum and number of occurrences of running sum in the map
        Map<Integer, Integer> sumAndCountMap = new HashMap<>();
        sumAndCountMap.put(0, 1); // number of occurrences of sum 0 is 1 (by not choosing any index).
        for (int num: nums) {
            runningSum += num;
            // sum[endIndex] - sum[startIndex] = k => sum[startIndex] = sum[endIndex] + k
            // Using the same logic to get number of occurrences of sum from the map.
            if (sumAndCountMap.containsKey(runningSum - k)) {
                count += sumAndCountMap.get((runningSum - k));
            }
            // Add number of occurrences of running sum to the map.
            sumAndCountMap.put(runningSum, sumAndCountMap.getOrDefault(runningSum, 0) + 1);
        }
        // return number of occurrences of sum k
        return count;
    }
}