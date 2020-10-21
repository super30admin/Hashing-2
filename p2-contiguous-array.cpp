// Time complexity is O(n) - n is no. of elements in vector...map.find() and map.insert() take O(1) time.
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
/*
    1. Since intial value of sum is 0, first we insert {0,-1} pair into the map. We consider this sum = 0
       has occurred at index -1.
    2. Whenever we find 1 in 'nums' vector, we increment sum by 1 and when we find 0 in 'nums' vector,
       we decrement sum by 0. This is done to keep track of equal number of 1's and 0's
    3. So, when the current running sum is already present in the map, it implies that the subarray
       starting from res[sum]+1 index to current index 'i' has equal number of 0's and 1's. We update the
       current maximum length of contiguous array accordingly.
    4. If the current running sum is not present in the map, we insert it along with index 'i'.
*/

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int sum = 0;
        int maximum = 0;
        unordered_map<int, int> res; // store running sum as key, index of nums as value
        res.insert(make_pair(0,-1));
        for(int i = 0; i < nums.size(); i++){
            sum += (nums[i] == 1 ? 1 : -1);
            if(res.find(sum) != res.end()){
                maximum = max(maximum, i - res[sum]);
            }
            else
                res.insert({sum, i});
        }
        return maximum;
    }
};
