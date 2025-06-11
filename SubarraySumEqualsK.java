// Time Complexity : O(n), where n is the length of the input array `nums`
// Space Complexity : O(n), for storing running sums in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This approach uses the concept of running sum with HashMap to count the number of subarrays whose sum equals `k`.
// The idea is to maintain a running sum and check how often the value `rsum - k` has appeared before.
// If it has appeared, then the subarray between that earlier point and the current index must sum to `k`.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // Stores running sum frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int rsum = 0;

        // Initialize map with base case: running sum of 0 has occurred once
        map.put(0, 1);

        for (int num : nums) {
            // Update the running sum
            rsum += num;

            // If (rsum - k) exists in the map, add its frequency to the result
            // This means there is a subarray ending at current index with sum k
            if (map.containsKey(rsum - k)) {
                result += map.get(rsum - k);
            }

            // Update the frequency of the current running sum
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }
        // Return total count of subarrays with sum equal to k
        return result;
    }
}