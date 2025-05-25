/**
 * Approach:
 * - Goal: Find the maximum length of a contiguous subarray with equal number of 0s and 1s.
 * - Replace 0 with -1 to transform the problem into finding the longest subarray with sum = 0.
 * - Use a prefix sum `p` and a HashMap to store the earliest index where a prefix sum occurred.
 * - Initialize map with (0, -1) to handle cases where the valid subarray starts at index 0.
 * - For each element:
 *   - Add +1 to `p` for 1, subtract 1 for 0.
 *   - If prefix sum `p` has been seen before, update `len` with the distance from the previous index.
 *   - If not seen, store the current index for this prefix sum.
 * - Return the maximum length found.
 */

// Time Complexity : O(N), where N is the length of the array
// Space Complexity : O(N), for storing prefix sum indices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int p = 0;     // Prefix sum
        int len = 0;   // Max length of valid subarray
        hm.put(0, -1); // To handle subarrays starting at index 0
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1, keep 1 as is
            if (nums[i] == 1)
                p += 1;
            else
                p -= 1;
            // If prefix sum seen before, update max length
            if (hm.containsKey(p)) {
                len = Math.max(len, i - hm.get(p));
            } else {
                // Store index of first occurrence of prefix sum
                hm.put(p, i);
            }
        }
        return len;
    }
}
