// Time complexity is O(n) - n is no. of elements in vector...map.find() and map.insert() take O(1) time.
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/*
    1. Unordered map is used. key - running sum; value - number of occurences of key
    2. Since intial value of sum = 0, we insert the pair {0,1} into the map.
       Here, the value '1' implies the one occurence of sum = 0.
    3. If 'sum-k' is present in the map, it indicates there are res[sum-k] subarrays with sum = k.
       We add it to the count.
    4. If current running sum is not present in the map, we insert it in the map. Or else,
       we increase it's value by 1.
 */

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int sum = 0; // running sum
        int count = 0; // count of number of subarrays with sum = k
        unordered_map<int, int> res;
        res[0] = 1;
        
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i];
            if(res.find(sum-k) != res.end())
                count += res[sum-k];
            
            if(res.find(sum) != res.end())
                res[sum]++;
            else
                res[sum] = 1;
        }
        return count;
    }
};
