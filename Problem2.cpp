
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>  
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size() - 1;
        unordered_map<int,int> m;
        m[0] = -1;   // prefix sum = 0 seen before starting

        int sum = 0;
        int maxlength = 0;

        // convert 0s to -1s
        for (int i = 0; i <= n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        // running prefix sum
        for (int i = 0; i <= n; i++) {
            sum += nums[i];


          //if sum already exists, update maxlength
            if (m.find(sum) != m.end()) {
                maxlength = max(maxlength, i - m[sum]);
            } else {
                m[sum] = i;  // record first occurrence
            }
        }
        return maxlength;
    }
};


