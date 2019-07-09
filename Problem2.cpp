//
// Created by shazmaan on 7/9/2019.
//

#include <iostream>
#include <algorithm>
#include <set>
#include <map>
#include <vector>

using namespace std;

class Solution{
public:
    int findMaxLength(vector<int>& nums) {
        int counter = 0; int ret = 0; int lastIndex = 0;
        map<int,int> hashmap; int index =0;
        for(int x : nums){
            if(x==0){
                counter ++;
            }else{counter--;}
            cout<<counter<<" counter\n";
            if((counter == 0)){
                ret+=2; lastIndex = index;
            }else if(hashmap.find(counter)!=hashmap.end()){
                cout<<(lastIndex)<<" lastIndex>(nums[hashmap[counter]]-abs(counter))\n";
                if(nums[hashmap[counter]]!=x && lastIndex>(hashmap[counter]-abs(counter))){
                    ret+=2; lastIndex = index;
                }
            }else{
                hashmap.insert(pair<int,int>(counter,index));
            }
            cout<<ret<<" ret\n---------\n";
            index++;
        }
        return ret;
    }
};

int main(){
    Solution s;
    vector<int> vec{0,1,1,0,1,1,1,0};
    vector<int> vec2{0,0,1,0,0,0,1,1};
    cout<<s.findMaxLength(vec)<<endl;
    return 0;
}

