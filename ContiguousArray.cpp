/*
Problem: Contiguous Array (Leetcode #525)

Description:
Given a binary array `nums`, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Approach:
- Convert the problem into finding the longest subarray with a running sum of 0.
- Treat 0s as -1 and 1s as +1. Then the problem becomes finding the longest subarray where the sum of elements is zero.
- Use a hash map to store the first occurrence index of each running sum (`rSum`).
- If the same `rSum` occurs again, it means the subarray between those indices has equal 0s and 1s.
- Track the maximum length of such subarrays using `maxCount`.

Time Complexity: O(n)
- We iterate through the array once, and map operations take O(1) on average.

Space Complexity: O(n)
- In the worst case, we may store a unique running sum for each index.

Did this code successfully run on Leetcode:
- Yes

Any problem you faced while coding this:
- map 0 → -1 is key to cover the whole array from start.
*/

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        int maxCount = 0;
        int rSum = 0;
        unordered_map<int, int> mp{{0, -1}}; // Initialize with rSum = 0 at index -1

        for (int i = 0; i < n; ++i) {
            // Convert 0 to -1 for the running sum
            rSum += nums[i] == 1 ? 1 : -1;

            if (mp.find(rSum) == mp.end()) {
                mp[rSum] = i; // Store the first occurrence of this rSum
            } else {
                maxCount = max(maxCount, i - mp[rSum]); // Update max length
            }
        }

        return maxCount;
    }
};
