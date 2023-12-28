// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea is to calculate running sum (by addingf 1 for 1 and -1 for 0) and store them in map
// along with its first occurance. We need this occurance as we want to find the longest contiguous array.
// If there is no runningSum we just insert it into the map with index it is found.
// Whenever we see the runningSum in map, we determine the max between the previous length vs the current length.


#include<vector>
#include<unordered_map>

class Solution {
public:
    int findMaxLength(std::vector<int>& nums) {
        int max = 0;
        int rSum = 0;
        std::unordered_map <int, int> map;
        map[0] = -1;

        for(int i = 0; i < nums.size(); i++)
        {
            //calcualting running sum
            if(nums[i] == 1)
            {
                rSum++;
            }
            else
            {
                rSum--;
            }

            // calculating the longest index
            if(map.find(rSum) != map.end())
            {
                max = std::max(max, i-map[rSum]);
            }
            else
            {
                map[rSum] = i;
            }
        }
        return max;
    }
};