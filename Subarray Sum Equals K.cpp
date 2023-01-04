// Time Complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int count = 0;
        int rSum = 0;
        unordered_map<int, int> map;
        // we put frequency of 0 as 1 as we have rSum = 0, to encounter the first subarray with sum = k
        map[0] = 1;
        for(int num: nums) {
            rSum += num;
            // chcking if rSum - k exists in hashmap, then add the no of times the value exists
            if(map.find(rSum - k) != map.end()) count += map[rSum - k];
            // increase the frequency, since we have encountered this sum
            map[rSum]++;
        }
        
        return count;
    }
};