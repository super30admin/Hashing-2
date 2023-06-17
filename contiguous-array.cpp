// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
  
using namespace std;

//using running sum to maintain a hashmap for that occurance of sum
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if(nums.size() == 0) return -1;

        unordered_map<int, int> rmap;
        int sum = 0;
        int maxlen = 0;
        rmap[0] = -1;

        for(int i = 0; i < nums.size(); i++){
            if(nums[i] == 0){  //encounter 0 then reduce sum by 1
                sum = sum - 1;
            }
            else{ //encounter 1 then increase sum by 1
                sum = sum + 1;
            }
            if(rmap.find(sum) != rmap.end()){ //if sum in the map check max
                maxlen = max(maxlen, i - rmap[sum]);
            }
            else{ // else add the index for that sum
                rmap[sum] = i;
            }
        }
        return maxlen;
    }
};