//525. Contiguous Array

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        // Create an unordered_map to store the running sum and its corresponding index
        unordered_map<int, int> map;
        // Initialize the map with the initial state (running sum = 0, index = -1)
        map[0] = -1;

        int runningSum = 0;
        int maxLength = 0;

        // Traverse the input array
        for (int i = 0; i < nums.size(); ++i) {
            // Update the running sum based on the current element (0 or 1)
            if (nums[i] == 0) {
                runningSum--;
            } else {
                runningSum++;
            }

            // Check if the running sum is already in the map
            if (map.find(runningSum) != map.end()) {
                // If yes, update the maxLength by comparing with the current index difference
                maxLength = max(maxLength, i - map[runningSum]);
            } else {
                // If the running sum is not in the map, add it with the current index
                map[runningSum] = i;
            }
        }

        // Return the maximum length of subarray with equal number of 0s and 1s
        return maxLength;
    }
};