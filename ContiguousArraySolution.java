// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class ContiguousArraySolution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        //map for running sum and index
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int length = 0;
        //Initialize this to capture base cases like [1, 0]
        map.put(0, -1);

        for(int i = 0; i < nums.length; i += 1) {
            //If we encounter 1 increase running sum by 1 
            //If we encounter 0 decrease running sum by 1
            if(nums[i] == 1) {
                runningSum += 1;
            } else {
                runningSum -= 1;
            }
            //If we encounter running sum, calculate the max length by substarcting current index with running sum index save in map.
            //If not found save running sum and index in the map. 
            if(map.containsKey(runningSum)) {
                length = Math.max(length, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return length;
    }
}