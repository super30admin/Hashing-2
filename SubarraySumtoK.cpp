// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int,int> mp;
        int cs = 0; 
        int count = 0; 
        mp[0] = 1; 
        for(int i = 0; i < nums.size(); i++) {
            cs += nums[i];
            if(mp.find(cs-k) != mp.end()) {
                count += mp[cs-k];        
            } 
            mp[cs]++; 
        }

        return count;        
    }
};