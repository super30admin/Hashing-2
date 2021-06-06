//Time Complexity : O(n)  
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int len = 0;
        int rSum=0;
        unordered_map<int, int>mp;
        mp[0] = -1;
        for (int i = 0; i<nums.size(); i++) {
            if (nums[i] == 1) rSum++;
            else rSum--;
            if (mp.find(rSum) != mp.end()) {
                len = max(len, i-mp[rSum]);
            }
            else {
                mp[rSum] = i;
            }
        }
        return len;
    }
};