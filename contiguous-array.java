// Time Complexity : O(n) because we traverse the array once
// Space Complexity : O(n) for the prefix sum HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// We use prefix sums and a HashMap to find the longest contiguous subarray with an equal number of 0s and 1s.
// We treat 0 as -1 and 1 as +1, so whenever the same running sum appears again, the subarray between those indices has an equal number of 0s and 1s.
// The HashMap stores the first occurrence of each running sum so we can calculate the maximum subarray length efficiently.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i] == 1 ? 1 : -1;

            if (!map.containsKey(rSum)) {
                map.put(rSum, i);
            } else {
                res = Math.max(res, i - map.get(rSum));
            }
        }

        return res;
    }
}