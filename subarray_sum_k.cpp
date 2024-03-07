// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, 
return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
*/

/*
Refer class video explaination.
*/


class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int count = 0;
        std::unordered_map<int, int> sMap;
        int rSum = 0;

        sMap[0] = 1;
        for(auto num : nums){
            rSum = rSum + num;
            int diff = rSum - k;
            if(sMap.find(diff) != sMap.end()){
                count += sMap[diff];
            }
            if (sMap.find(rSum) == sMap.end()){
                sMap[rSum] = 1;
            } else {
                sMap[rSum] += 1; 
            }
        }
        return count;
    }
};