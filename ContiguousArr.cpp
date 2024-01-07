// Time Complexity : O(n)
// Space Complexity : O(n) as we maintain a hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
#include<unordered_map>
#include<vector>
using namespace std;
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        //key will be  unique running sum and value will be earliest index 
        unordered_map<int,int> uniqueSum;
        int maxLen =  0;
        int rSum=0;
        int i =-1;
        uniqueSum[rSum] = i;
        i++;
        for(i;i<nums.size();i++)
        {
            nums[i]?rSum++:rSum--;
            if(uniqueSum.find(rSum)!=uniqueSum.end())
            {
                maxLen = max(maxLen,(i-uniqueSum[rSum]));
            }
            else
            {
                uniqueSum[rSum]=i;
            }
        }
        return maxLen;
    }
};