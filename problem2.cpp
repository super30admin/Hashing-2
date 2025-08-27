// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use a running sum approach (+1 for 1 and -1 for 0) to keep track of how many ones and zeroes there are at any given index in the array
// We insert the first index of a running sum at our first encounter, if we get the same running sum again that means the array between the indices is balanced (equal no. of 1s and 0s)
// We use a global max length variable to keep track of the longest contiguous subarray formed

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> runningSumMap; // to maintain the first occurences of the running sums
        runningSumMap[0] = -1; // dummy entry to handle edge cases
        int maxLength = 0; // to track max contiguous subarray
        int runningSum = 0; 
        for(int i=0; i<nums.size(); i++){
            if(nums[i] == 1) { // 1
                runningSum += 1;
            } else { // 0
                runningSum -= 1;
            }
            if(runningSumMap.find(runningSum) != runningSumMap.end()) { // already exists in map
                int length = i - runningSumMap[runningSum];
                maxLength = max(maxLength, length); // update max length if needed
            } else {
                runningSumMap[runningSum] = i;
            }
        }
        return maxLength;
    }
};

int main() {
    Solution solution;
    vector<int> nums1 = {0,1,1,1,1,1,0,0,0};
    vector<int> nums2 = {0,1};
    vector<int> nums3 = {0,1,0};

    cout<<"Longest Contiguous Subarray for nums1 is of length "<<solution.findMaxLength(nums1)<<endl;
    cout<<"Longest Contiguous Subarray for nums2 is of length "<<solution.findMaxLength(nums2)<<endl;
    cout<<"Longest Contiguous Subarray for nums3 is of length "<<solution.findMaxLength(nums3)<<endl;
}