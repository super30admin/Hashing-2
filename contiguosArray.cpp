// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int> map;
        int rSum=0;
        int maxLen=0;
        map.insert({0,-1});

        for(int i=0;i<nums.size();i++){
            if(nums[i]==0){

                rSum--;

            }
            else{
                rSum++;
            }

            if(map.find(rSum)!=map.end()){
                maxLen=max(maxLen,i-map[rSum]);



            }
            else{
                map.insert({rSum,i});
            }

        }

        return maxLen;
        
    }
};