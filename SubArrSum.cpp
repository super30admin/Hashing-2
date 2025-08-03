#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a running sum also called prefix sum to keep track of the sum so far
Then we check if rSum-k was seen before- if yes, we've found a valid subarray
Finally, we count how many times each running sum appeared using hashmap
*/
class Solution{
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> map;
        int rSum=0, result=0;
        map[0]=1;
        for(int num : nums){
            rSum+=num;
            int cmp=rSum-k;
            if(map.find(cmp)!=map.end()){
                result+=map[cmp];
            }
            map[rSum]++;
        }
        return result;
    }
};
int main(){
return 0;
}