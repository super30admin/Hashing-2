// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Using a running sum pattern and a hashmap to store first occurance of the runningSum

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> sumIndex;
        sumIndex[0] = -1;

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.size(); ++i) {
            sum += (nums[i] == 1) ? 1 : -1;

            if (sumIndex.find(sum) != sumIndex.end()) {
                maxLength = max(maxLength, i - sumIndex[sum]);
            } else {
                sumIndex[sum] = i;
            }
        }

        return maxLength;        
    }
};