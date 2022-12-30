560. Subarray Sum Equals K
------------------------------
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Answer:-
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no 
// Any problem you faced while coding this : failing testcase nums = [1,-1,0] , k = 0, output = 2, expected = 3;


class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map <int, int> mmap;
        mmap.insert(pair<int,int>(0,1));
        int rSum = 0; int count = 0; 

        for(int i=0; i< nums.size(); i++){
            rSum +=nums[i];

            if(mmap.find(rSum - k) == mmap.end()) {}
            else {
                auto it = mmap.find(rSum - k);
                count = count + it->second;
            } 
            if(mmap.find(rSum) == mmap.end()) {
                mmap.insert(pair<int,int>(rSum, 1));
            } else {
                auto itt = mmap.find(rSum);
                mmap.insert(pair<int,int>(rSum, itt->second + 1));                
            }
        }
        return count;
    }
};
