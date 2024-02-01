import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Calculate the running sum, if that running sum has occurred before,
 * get the difference between the indices to get the length. Keep storing
 * the max length
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int result = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }

            if (map.containsKey(rSum)) {
                result = Math.max(result, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }

        return result;

    }
}
