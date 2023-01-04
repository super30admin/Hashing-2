// Time Complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> map;
        int maxL = 0, rSum = 0;
        // for taking care of the edge case
        map[0] = -1;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 0) rSum--;
            else rSum++;
            if(map.find(rSum) != map.end()) maxL = max(maxL, i - map[rSum]); // calculating the length of subarray and putting the max in max
            else map[rSum] = i;
        }
        return maxL;
    }
};