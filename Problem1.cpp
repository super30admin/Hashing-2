//
// Created by shazmaan on 7/9/2019.
//

#include <iostream>
#include <algorithm>
#include <map>
#include <string>
#include <vector>

using namespace std;

class Solution{
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int,int> hashmap;
        int ret = 0; int totalSum = 0;
        for(int x = 0; x<nums.size(); x++){
            int prevTot = totalSum;
            totalSum += nums[x];
            if(totalSum==k){
                ret++;
                totalSum = nums[x];
            }else if((hashmap.find(totalSum)!=hashmap.end())){
//                cout<<hashmap[k-totalSum]<<" hash "<<nums[x]<<" nums\n";
                ret++;
//                totalSum = 0;
            }else{
                hashmap.insert(pair<int,int>(k-totalSum,totalSum));
            }
//            cout<<totalSum<<" TotalSum "<<k-totalSum<<" k-tot\n";
        }
        return ret;
    }
};

int main(){
    Solution s;
    vector<int> vec{9,4,20,3,10,5};
    cout<<s.subarraySum(vec,33); cout<<"----------------\n";
//    vector<int> vec2{9,4,20,3,10,5};
//    s.subarraySum(vec2,33); cout<<"----------------\n";//0+1 2-1
    vector<int> vec3{1,1,1};
    cout<<s.subarraySum(vec3,2);
    cout<<"----------------\n";
    return 0;
}