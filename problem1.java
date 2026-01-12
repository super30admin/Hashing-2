// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to understand prefix sum logic.


// Your code here along with comments explaining your approach in three sentences only
// We use prefix sum and a hashmap to store how many times each prefix sum has appeared.
// At each index, we check if (currentSum - k) exists in the map and add its count to answer.
// Then we store the currentSum into the map and continue.

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int n : nums) {
            sum += n;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
