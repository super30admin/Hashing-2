// Time Complexity: O(n), where n is the number of elements in nums.
// Space Complexity: O(n), as the HashMap stores at most n+1 prefix sums.

// Approach: Create a HashMap to store prefix sums and their first
// occurring indices. Add (0,-1) to the map to represent the initial prefix sum.
// Iterate over nums, add 1 to prefixSum if nums[i] is 1 and subtract 1 if it is 0.
// If the prefixSum already exists in the HashMap, update maxLen using the
// difference between the current and stored index, otherwise store it in the map.
// Return maxLen.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
