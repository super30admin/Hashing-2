// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
     unordered_map<int,int> mymap;
        mymap[0] = 1;
        
        int sum = 0;
        int ans = 0;
        for (int n = 0; n < nums.size(); n++) {
            sum += nums[n];
            if (mymap.find(sum - k) != mymap.end())
                ans += mymap[sum - k];
            mymap[sum]++;
        }
        return ans;
    }
};