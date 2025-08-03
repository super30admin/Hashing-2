#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Maintain an rSum variable where for every 0 decrement the value and
increment for every 1. take the maxCount out of the map and itself
and finally return the maxCount
*/
class Solution{
public:
    int findMaxLength(vector<int>& nums){
        unordered_map<int, int> map; //rSum : Index
        int rSum = 0, maxCount = 0;
        map[0] = -1;

        for(int i=0;i<nums.size();i++){
            if(nums[i] == 0) rSum++;
            else rSum--;

            if(map.find(rSum) != map.end()){
                maxCount = max(maxCount, i-map[rSum]);
            }else map[rSum] = i;
        }
        return maxCount;
    }
};
