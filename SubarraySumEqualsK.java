// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
 
// Constraints:
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Base case : null or empty array
        if (nums == null || nums.length == 0){
            return 0;
        }

        // Map to store frequency of running sums
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0, count = 0; // Running sum, and count of subarrays whose sum equals k
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            rSum = rSum + nums[i]; // updating the running sum
            if(map.containsKey(rSum - k)){
                count = count + map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return count; // returning total number of valid subarrays
    }
}