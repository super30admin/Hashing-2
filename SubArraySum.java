// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
     public int subarraySum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // inserted to handle edge case: in order to include from the starting index
        int count = 0;
        int runSum = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            runSum += nums[i]; //Keep track of running sum

            int y = runSum - target; //keeps difference of running sum and target
 
            if (map.containsKey(y)) { //difference if found in map increase the counter
                count += map.get(y);
            }
            map.put(runSum, map.getOrDefault(runSum, 0) + 1); //do a put operation in MAP
        }

        return count;
    }
}
