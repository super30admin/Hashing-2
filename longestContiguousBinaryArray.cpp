// Time Complexity : O(n) where n is the size of the array 
// Space Complexity : O(n) map can have an entry for every number 
// Did this code successfully run on Leetcode : Yes


/*
we maintain a running sum of the array by adding -1 for every 0 and 1 for every 1. 
Every time a number repeats in the running sum array, that means the numbers between them add up to 0
which essentially means the number of 0s and 1s are equal 


array:  0   1   0   0   1   1   0   0   1
rSum : -1   0  -1  -2  -1   0  -1  -2  -1

so all numbers between -1 and -1 sum up to 0 i.e has equal number of 0s and 1s 

we add a key:value pair or 0: -1 to handle for 0s in the code for the first 2 elements 

key:value => rSum: first seem smallest index 

*/

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        unordered_map<int, int> map;
        int result = 0;

        //Initialising for [0 1] edge case
        map[0] = -1;

        int runningSum = 0;
        for(int i=0; i<nums.size(); i++){
            //updating rSum
            if(nums[i] == 0)
                runningSum += -1;
            else
                runningSum += 1;

            //if we don't find the running sum once before in the map, we add it since it will be the smallest 
            if(map.find(runningSum) == map.end())
                map[runningSum] = i;
            else
            //if we find it in the map, subtract it from the current index and update result if its bigger than the current result 
                result = (i-map[runningSum] > result)?(i-map[runningSum]):result;
        }
        return result;
    }
};