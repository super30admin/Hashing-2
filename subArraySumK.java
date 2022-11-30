// Time Complexity : O(n), n is the length of the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * we approach this problem by calculating the subarrays and checking its sum, but to checking every subarray will lead ot O(n^2)
 * To reduce to O(n), we are using the running sum approach.
 * we calculate the running sum for every integer in the array, and check the remaining sum form the target sum.
 * If the sum exists, we increment the result counter by the frequency of the running usm.
 * If does not exists, we add it to the map with the frequency.
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            if (map.containsKey(rSum - k)) {
                result += map.get(rSum - k);
            }
            if (!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }

        return result;

    }
}