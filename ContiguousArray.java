// https://leetcode.com/problems/contiguous-array/
// Time complexity: O(N)
// Space complexity: O(N) for map

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countAndIndexMap = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        countAndIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                count ++; // increase the count
            } else {
                count --; // decrease the count
            }
            if (!countAndIndexMap.containsKey(count)) {
                // If count does not exist in the map, add it along with index.
                countAndIndexMap.put(count, i);
            } else {
                // If count exists in the map, difference between current index and the index at first occurance of the count is the length of contiguous subarray with equal number of 0 and 1.
                maxLength = Math.max(maxLength, i - countAndIndexMap.get(count));
            }
        }
        return maxLength;
    }
}