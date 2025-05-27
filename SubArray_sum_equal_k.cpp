#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int>map;
        map[0]=1;
        int count=0,rsum=0;
        for(int i=0;i<nums.size();i++)
        {
            rsum += nums[i];
            if(map.find(rsum-k)!=map.end()){
                count+=map[rsum-k];
            }
            map[rsum]+=1;
        }
        return count;
    }
};