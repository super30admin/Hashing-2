// Time Complexity : O(N) 

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Initially, converted all 0's to -1 to find the preSum.
// Check if presum is not present in the map, add presum with index.
// If present, find diff between index and presum index and find max.

// 525. Contiguous Array
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        map<int,int> mp;
        int ans = INT_MIN;
        mp[0] = -1;
        int val,diff;
        int prefix = 0;
        for(int i=0;i<nums.size();i++){
            if(nums[i] == 0)
                val = -1;
            else
                val = 1;
            prefix += val;
            if(mp.find(prefix) == mp.end()){
                mp[prefix] = i;
            }
            else{
                diff = i - mp[prefix];
            }
            
        ans = max(ans,diff);

        }
        return ans;
    }
};