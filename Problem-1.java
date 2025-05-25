/**
 * Approach:
 * - Use prefix sum technique with a HashMap to store cumulative sum frequencies.
 * - Initialize prefix sum `p = 0` and result count `c = 0`.
 * - Put (0, 1) in the map to handle subarrays that start from index 0.
 * - For each element:
 *   - Add current element to prefix sum `p`.
 *   - Check if `(p - k)` exists in the map → this means there is a subarray that sums to `k`.
 *   - If yes, add the frequency of `(p - k)` to the result count `c`.
 *   - Update the frequency of prefix sum `p` in the map.
 * - Return the total count `c` of subarrays that sum to `k`.
 */

// Time Complexity : O(N), where N is the length of the array.
// Space Complexity : O(N), for the prefix sum hashmap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Handle edge case when array has only one element
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int p = 0; // Prefix sum
        int c = 0; // Count of valid subarrays

        hm.put(0, 1); // Initialize with sum 0 to handle subarrays starting at index 0

        for (int i = 0; i < nums.length; i++) {
            p += nums[i]; // Update prefix sum
            int x = p - k;

            // If (prefix - k) exists, there are subarrays ending at i with sum = k
            if (hm.containsKey(x)) {
                c += hm.get(x);
            }

            // Update prefix sum frequency
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }

        return c;
    }
}
