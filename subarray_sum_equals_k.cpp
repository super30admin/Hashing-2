// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea is to calculate running sum of the elements and find the total number of subarrays.
// if running sum is not present in the map, insert it with occurance as 1. 
// While inserting elements we simultaneously check for complment sum( this is running sum minus the target aka K value) if 
// it is present in the map, then we increment the counter with the running sum's value. 


#include<unordered_map>
#include<vector>

class Solution {
public:
    int subarraySum(std::vector<int>& nums, int k) {
        int rSum = 0;
        int count = 0;
        std::unordered_map <int, int> map;
        map[0] = 1;

        for(int i = 0; i < nums.size(); i++)
        {
            // calculating running sum
            rSum += nums[i];

            // if complement is present then incrementr counter
            if(map.find(rSum - k) != map.end())
            {
                count += map[rSum - k];
            }

            // if running sum is not ther ein map, add it with number of times it occured.
            if(map.find(rSum) == map.end())
            {
                map[rSum] = 0;
            }
            map[rSum]++;
        }
        return count;
    }
};