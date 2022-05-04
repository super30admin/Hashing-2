// Time Complexity :O(n^2)
// Space Complexity :constant
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :TLE

//traversing with nested for loop to check all occurrences of sum equals k
class Solution {
    public int subarraySum(int[] nums, int k) {
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}