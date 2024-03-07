// (Apporach 3)
// Time Complexity : O(N)
// Space Complexity : O(N) ... N number of different sum values are possible which 
//                             needs to be stored in map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/contiguous-array/

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
*/

/*
'Running Sum method' is used for this problem.
rSum varible is used to store the addition. When element is 1, this sum value is incremented by 1
and for 0, it is decremented by 1.
For each unique sum value map is created to store the first index where this sum value was occured.
Distance between same sum values gives us balalnced substring of 0 and 1.

example :
sum value at -1 location is assumed to be 0.
Index      0  1  2  3  4  5  6  7  8  9  10  11  12
          [1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0,  0,  1]
sum =  -1  0  -1 0  -1 0  1  0  1  2  3  2   1   2
           [-----------------] longest balanced array of size 6
                          [------------------] another longest balanced array of size 6
*/


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int maxLen = 0;
        std::unordered_map<int,int>fMap;
        fMap[0] = -1;
        int rSum = 0;
        int size = nums.size();

        for (int i = 0; i<size; i++){
            if(nums[i] == 0) {
                rSum -= 1;
            } else {
                rSum += 1;
            }
            if (fMap.find(rSum) == fMap.end()){
                fMap[rSum] = i;
            } else {
                maxLen = std::max(maxLen, (i-fMap[rSum]));
            }
        }
        return maxLen;
    }
};