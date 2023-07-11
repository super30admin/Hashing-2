// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution{
public:
    int subarraySum(vector<int>& nums, int k) {

        unordered_map<int,int> map;
        map[0]=1;
        int rSum=0;
        int count=0;

        for(int i=0; i < nums.size();i++){
            rSum = rSum+nums[i];
            int com = rSum-k;
            if(map.find(com)!=map.end()){
                count=count+map[com];

            }
            if(map.find(rSum)!=map.end()){
                map[rSum]=map[rSum]+1;
            }
            else{
                map[rSum]=1;
            }
            
        }

        return count;


        
        
    }

    
};