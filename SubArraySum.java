// Time Complexity : O(N), will go through each element
// Space Complexity : O(N), we need to keep the previous sum for all indices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach :
// The brute force way is to run  2 for loops and calculate the sum between index i and j and check if it is equal to k.
// To avoid using the inner loop, we need to store the previous sum (till index i) in the map. So that at any index we
// can check if the total sum (at index i) - previous sum(i-1) is equal to K.
// At any point, we will know the total sum and K, then we can check (total sum - k) = previous sum is in the map or not.
// In other words, if the total sum is current sum of the sub array, do we have any subarray value in the map that is total sum - k;
// cs - ps = k, thus
// cs - k = ps and ps is stored in the map.

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0] == k ? 1 : 0;


        // Use hashmap to keep the previous sum and the count of how many times it has appeared before. It indicates that
        // the current sum can form multiple subarray with value K, so this count should be added in the result.
        Map<Integer, Integer> previousSumMap = new HashMap<>();
        // Initialize the map indicating the previous sum is 0 and has occurred once. It is useful
        // for checking the previous sum at index 0;
        previousSumMap.put(0, 1);

        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (previousSumMap.containsKey(currentSum - k)) {
                count += previousSumMap.get(currentSum - k);
            }
            // store the current sum with updated count
            previousSumMap.put(currentSum, previousSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
