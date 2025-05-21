/*
Problem: Subarray Sum Equals K (Leetcode #560)


Approach:
- Use a running sum (`rSum`) and a HashMap to store the frequency of running sums encountered so far.
- For each element in the array, update `rSum` by adding the current element.
- Check if `(rSum - k)` exists in the map. If it does, it means there is a subarray ending at the current index which sums to `k`.
- Add the frequency of `(rSum - k)` to the count.
- Update the frequency of `rSum` in the map using `getOrDefault`.

This approach avoids nested loops and ensures a time-efficient solution using prefix sums and a hashmap.

Time Complexity: O(n)
- We traverse the array only once and all map operations are O(1) on average.

Space Complexity: O(n)
- In the worst case, the map stores a prefix sum for every index.

Did this code successfully run on Leetcode:
- Yes

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int rSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 to handle subarrays that sum to k starting from index 0

        for (int i = 0; i < n; ++i) {
            rSum += nums[i];

            // Check if there exists a prefix sum that when removed leaves a subarray sum of k
            if (map.containsKey(rSum - k)) {
                count += map.get(rSum - k);
            }

            // Update the frequency of the current running sum
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return count;
    }
}
