// Problem: Contiguous subarray
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. We use running sum pattern here to remove nested iterations
// 2. We maintain a running sum by incrementing sum by 1 if it's 1 and
// decreasing by 1 if it's 0
// 3. If we encounter a rSum, that we have already seen before, that means it's
// balanced and we can store the length
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int findMaxLength(vector<int> &nums) {
    int n = (int)nums.size();
    int maxi = 0;
    int rSum = 0;
    unordered_map<int, int> u;
    u[0] = -1;

    for (int i = 0; i < n; i++) { // O(n)
      if (nums[i] == 0)
        rSum--;
      else
        rSum++;
      if (u.count(rSum) > 0) {
        maxi = max(maxi, i - u[rSum]);
      } else {
        u[rSum] = i;
      }
    }

    return maxi;
  }
};
