import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Calculate the running sum, and store it in the map as a key and number of
 * occurrences as value. If the difference between running sum and target has
 * occurred before, add its value to the result
 */
public class SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int rSum = 0;
        int result = 0;

        for(int num: nums) {
            rSum += num;
            int diff = rSum - k;

            if(map.containsKey(diff)) {
                result += map.get(diff);
            }

            if(map.containsKey(rSum)) {
                map.put(rSum, map.get(rSum) + 1);
            } else {
                map.put(rSum, 1);
            }
        }

        return result;

    }
}
