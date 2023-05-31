# Time Complexity : O(n) where n = length of array
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

// Use hashmap to store frequency of sums and compare to check if sum is equal to k.

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int ls=0;
        int len=nums.size(), count=0; 
        map<int,int> m;
        m[0]=1;
        for(int i=0;i<len;i++){
            ls+=nums[i];

            count+=m[ls-k];
            m[ls]++;
        }
        return count;
    }
};