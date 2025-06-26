// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Use a HashMap to store runningSum along with frequencies
// Apply a two sum approach and get different kinds of subarrays that can reach the given sum of target k

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
                unordered_map<int, int> prefixSumFreq;
        prefixSumFreq[0] = 1;

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            if (prefixSumFreq.find(currentSum - k) != prefixSumFreq.end()) {
                count += prefixSumFreq[currentSum - k];
            }
            prefixSumFreq[currentSum]++;
        }

        return count;
    }
};