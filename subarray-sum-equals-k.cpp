// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>
#include <unordered_map>
  
using namespace std;

// running sum check if rsum - target is present in the hashmap and increment the count if yes
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        if(nums.size() == 0) return -1;
        unordered_map<int, int> rmap;

        int rsum = 0;
        int count = 0;
        rmap[0] = 1;

        for(int i = 0; i < nums.size(); i++){
            rsum += nums[i];
            if(rmap.find(rsum - k) != rmap.end()){//check if rsum - target in the map and increment count
                count += rmap[rsum - k];
            }
            if(rmap.find(rsum) != rmap.end()){//check if rsum in the map and increment value in map
                rmap[rsum]++;
            }
            else{//if not present then add that in the map
                rmap[rsum] = 1;
            } 
        }
        return count;
    }
};