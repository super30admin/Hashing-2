// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// The approach involves traversing through the given array, maintaining a cumulative sum (sum[i]) at each index i.
// A hashmap (map) is used to store the cumulative sum up to all indices encountered so far,
// along with the frequency of occurrence of each sum.

import java.util.HashMap;

public class problem1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}