// Time Complexity : O(N) 

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Created a map and stored the prefix sum : the number of times the
// sum apprered till now. Find the diff between the presum and target .
// Check if diff is present in map else add the presum and move on. 


// 560. Subarray Sum Equals K
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int preSum = 0;
        int cnt = 0;
        map<int,int> mp;
        mp[0] = 1;
        for(int i=0;i<nums.size();i++){
            preSum += nums[i];
            int diff = preSum - k;
            if(mp.find(diff) != mp.end()){
                cnt += mp[diff];
            }
            mp[preSum] += 1; 
        }
        return cnt;
    }
};