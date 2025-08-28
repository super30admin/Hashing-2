// Problem: Subarray sum equals k
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. We use running sum pattern here to remove nested iterations
// 2. We maintain a running sum if rSum - target is seen before, we add the
// frequency of how many times it's been seen
// 3. And we update the hashmap accordingly
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int subarraySum(vector<int> &nums, int k) {
    int n = (int)nums.size();
    unordered_map<int, int> u;
    u[0] = 1;
    int rSum = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      rSum += nums[i];
      int findVal = rSum - k;
      if (u.count(findVal) > 0) {
        res += u[findVal];
      }
      u[rSum]++;
    }
    return res;
  }
};
