// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class SubArraySolution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = 0;
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //Initialize this to capture base cases.
        map.put(0, 1);

        for(int i = 0; i < nums.length; i += 1) {
            runningSum += nums[i];
            if(map.containsKey(runningSum - k)) {
                length += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return length;
    }
}
