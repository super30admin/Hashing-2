O(N) time, O(1) space
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int> m;
        m[0]=-1;
        int rSum=0;
        int result=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1) rSum++;
            else rSum--;
            if(m.find(rSum)==m.end()){
                m[rSum]=i;
            }
            result = max(result,i-m[rSum]);
        }
        return result;
    }
};
