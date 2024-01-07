// Time Complexity : O(n)
// Space Complexity : O(n) as we maintain a hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
#include<unordered_map>
#include<vector>
using namespace std;
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        //key to store unique rsum and value to store occurance
        unordered_map<int,int> uniqueSum;
        int total=0;
        int rSum=0;
        //inserting 0 so that to capture if 2 is target and running sum is 2 so 2-2 is 0 if we dont have zero in the map it wont catch
        uniqueSum[rSum] =1;
        for(int i =0;i<nums.size();i++)
        {
            rSum+=nums[i];
            if(uniqueSum.count(rSum-k))
                total+=uniqueSum[rSum-k];
            
            uniqueSum[rSum]++;
        }
        return total;
    }
};