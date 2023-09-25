// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int max = 0;
        //Always put first value in map to avoid failure in case when it starts with 0
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningSum -= 1;
            } else {
                runningSum += 1;
            }
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, i);
            } else {
                max = Math.max(max, i - map.get(runningSum));
            }
        }
        return max;
    }

}
