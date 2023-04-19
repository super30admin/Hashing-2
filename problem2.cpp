// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// in the loop , we calculate the rsum by increasing 1 if we get 1 and decresing 1 if we get 0.
// so, our intention is to check equal number of 0's and 1's. we maintain a map to store the index of first occurence of the rsum.
// so that whenever we encounter an rsum , we update the maxLength.
// Here we get a problem considering the initial subarray, to overcome that we fill the map with (0,-1) so that when taking the difference,
// the initial subarray is also taken into account.


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if(nums.empty() || nums.size()==0)
        {
            return 0;
        }
        unordered_map<int,int>map;
        map[0]=-1;
        int rsum = 0;
        int maxLength = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==0) rsum-=1;
            else rsum+=1;
            if(map.find(rsum)!=map.end())
            {
                maxLength = max(maxLength, i - map[rsum]);
            }
            else{
                map[rsum] = i;
            }
        }
        return maxLength;
        
       
        
    }
};