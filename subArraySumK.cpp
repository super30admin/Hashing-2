O(N) time, O(N) space
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        m[0]=1;
        int count=0;
        int rSum=0;
        for(int i=0;i<nums.size();i++){
            rSum+= nums[i];
            if(m.find(rSum-k)!=m.end()){
                count+= m[rSum-k];
            }
            m[rSum]++;
        }
        return count;
    }
};
