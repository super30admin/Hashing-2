// Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        int count = 0;
        vector<int> prefixsum(n, 0);

        // Building a prefix sum array
        prefixsum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }

        //an unordered map which stores the frequecy of same prefix sum
        unordered_map<int, int> m;

        // when prefixsum itself is equal to target
        for (int j = 0; j < n; j++) {
            if (prefixsum[j] == k) count++;

        //value we need to find is prefixsum - target, search for the value in the map
        //if value exists in map, add its frequency to count

            int val = prefixsum[j] - k;
            if (m.find(val) != m.end()) {
                count += m[val];
            }
        
        //if prefixsum[j] doesnt exist in map,store it, initialize with 0, increment on occurance

            if (m.find(prefixsum[j]) == m.end()) {
                m[prefixsum[j]] = 0;
            }
            m[prefixsum[j]]++;
        }
        return count;
    }
};

