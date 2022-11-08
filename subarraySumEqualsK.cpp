// Time Complexity : O(n) where n is the size of the array 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes

/*
We keep a running sum of all the numbers 
At every point, if we subtract the k from the running sum and that new number is found in the map, that means the sum of subarray from that point to current is k

Basically, currentSum + k = if present in the array ahead 
that subarray will total to k

So we mantain a map of the runningSum and the count 
Initialise it with 0:1 so if we see k in the future, we don't lose the first few elements adding up to k
*/

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        //edge case
        if(nums.size() == 0)
            return 0;
        //rSum : count 
        unordered_map<int,int> map;
        map[0] = 1;
        int result = 0;
        int runningSum = 0;
        for(int i=0; i<nums.size(); i++){
            runningSum += nums[i];
            if(map[runningSum-k])
                result += map[runningSum-k];
            map[runningSum]++;
        }
        return result;
    }
};