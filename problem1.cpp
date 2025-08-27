// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use a running sum approach for this question
// Track the running sum at each index and update the count of it in the map
// At every iteration, take the (rSum - k) value & search for it in the map, if we find it, increase the count by the value stored @ key = rSum - k

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> runningSumMap;
        runningSumMap[0] = 1; // dummy entry for edge cases
        int rSum = 0;
        int count = 0;
        for(int i=0; i<nums.size(); i++) {
            rSum += nums[i];
            if(runningSumMap.find(rSum - k) != runningSumMap.end()){ // check if we can find (rSum - k) to find a subarray with sum = k
                count += runningSumMap[rSum-k];
            }
            runningSumMap[rSum]++; // update the count of rSum in the map
        }
        return count;
    }
};

int main() {
    Solution solution;
    vector<int> nums1 = {1, 1, 1}; int k1 = 4;
    vector<int> nums2 = {1,2,3}; int k2 = 3;
    vector<int> nums3 = {3,4,7,2,-3,1,4,2,0,1}; int k3 = 7;

    cout<<"Subarrays with sum = "<<k1<<" for nums1: "<<solution.subarraySum(nums1, k1)<<endl;
    cout<<"Subarrays with sum = "<<k2<<" for nums2: "<<solution.subarraySum(nums2, k2)<<endl;
    cout<<"Subarrays with sum = "<<k3<<" for nums3: "<<solution.subarraySum(nums3, k3)<<endl;

    return 0;
}