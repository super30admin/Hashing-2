// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting the logic 

// Your code here along with comments explaining your approach - Running Sum Approach
import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLen = 0;

        // Dummy value in the map to catch the initial balanced subarray
        map.put(0, -1);

        // Calculate the Running Sum and check if it exists in the map
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                int lastIndexFound = map.get(count);
                maxLen = Math.max(maxLen, (i - lastIndexFound));
            }
        }

        // Return the maximum length of the subarray
        return maxLen;
    }
}