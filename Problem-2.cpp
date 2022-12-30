
525. Contiguous Array
---------------------------
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Answer:-
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> mmap;
        mmap.insert(pair<int, int>(0, -1));
        int rSum = 0;
        int result = 0;
        for(int i=0; i< nums.size(); i++) {
            if(nums[i] == 0)
                rSum--;
            else 
                rSum++;
            if(mmap.find(rSum) != mmap.end()) {
                auto it = mmap.find(rSum);
                result = max(result, i - it->second);
            } else {
                mmap.insert(pair<int, int>(rSum, i));
            }
        }
        return result;
    }
};
