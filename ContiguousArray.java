// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/contiguous-array/)
// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
// Example:
// Input: nums = [0,1,1,1,1,1,0,0,0]
// Output: 6
// Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 
// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // Base case : edge conditions
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int max = 0, rSum = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); // Key : running sum, Value : index
        map.put(0, -1); // Initial entry (0, -1) to handle case when subarray starts from index 0
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum = rSum - 1;
            }
            else {
                rSum = rSum + 1;
            }

            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else {
                map.put(rSum, i);
            }
        }
        // Returning maximum length found
        return max;
    }
}