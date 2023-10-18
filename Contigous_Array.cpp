#include "unordered_map"
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int result=0, ans=0;
        unordered_map<int, int> myMap;
        myMap[0]=-1;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1){
                result++;
            }
            else {
                result--;
            }
            if((!myMap.count(result))){
                myMap[result]=i;
            }
           ans = max(ans, (i - myMap[result]));
        }
        
        return ans;
    }
};
