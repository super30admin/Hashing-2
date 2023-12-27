// Subarray Sum Equals K
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        std::unordered_map<int, int> map;
        map[0] = 1;
        int count = 0;
        int rSum = 0;

        for (int i = 0; i < nums.size(); ++i) {
            rSum += nums[i];

            // Check if there is a subarray with sum (rSum - k)
            if (map.find(rSum - k) != map.end()) {
                count += map[rSum - k];
            }

            // Update the frequency of the current running sum
            if (map.find(rSum) == map.end()) {
                map[rSum] = 1;
            } else {
                map[rSum]++;
            }
        }

        return count;
    }
};