//560. Subarray Sum Equals K

/*
Do the same as getting the running sum; but since we need the count use y = x-z 
use hashmap with runningsum and number of times the running sum has occured
check if y is present in the hash if present, increment the count by the hashed value. ortherwise hash the running sum
define hash[0] to 1 so that we dont miss subarray with single element like just [k]
Time complexity: O(N)
Space complexity: O(N)
*/

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {

    int arrays = 0;
    int runningSum = 0;
    unordered_map<int, int> hash;
    hash[0] = 1;

    for(int i=0; i<nums.size(); i++){
        runningSum += nums[i];
        
        //to find complement
        if(hash.find(runningSum-k) != hash.end())
        {
            arrays += hash[runningSum-k]; 
        }
        if(hash.find(runningSum) == hash.end()){
             hash[runningSum] = 0;
        }
        hash[runningSum]++;
    }
    return arrays;

    }
};