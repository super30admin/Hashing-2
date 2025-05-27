#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int>map;
        map[0]=-1;
        int sum=0,maxi=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1){
                sum-=1;
            }else{
                sum+=1;
            }
            if(map.find(sum)!=map.end()){
                maxi = max(maxi,i-map[sum]);
            }else{
                map[sum]=i;
            }   
        }
        return maxi;
        
    }
};