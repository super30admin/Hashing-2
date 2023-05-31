// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        map<int,int> mp; 
        int cSum = 0; 
        int maxLength = 0; 

        mp[0] = -1; 

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 0) cSum -= 1; 
            else cSum += 1; 

            if(mp.find(cSum) != mp.end()) {
                maxLength = max(maxLength, i - mp[cSum]);
            } else mp[cSum] = i; 
        }

        return maxLength;     
    }
};