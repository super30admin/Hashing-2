import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n) //using HashMap
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class SubArraySumsEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int runningSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (map.containsKey(runningSum - k)) {
                count += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

}
