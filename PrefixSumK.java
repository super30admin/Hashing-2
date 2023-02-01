// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.HashMap;

/**
 * This is similar to two sum question. Take a hashmap to store
 * the prefix sum and the count it appeared in the array. Iterate
 * over each index in array. Add the number to prefix and push it
 * to the map. Before that check if prefix sum - k is already present
 * in the map. If so, update answer by the value of h(prefix - k).
 * Note that to avoid a case where the prefix sum = k, we add a (0, 1)
 * pair. Finally return the answer.
 *
 */
public class PrefixSumK {
	public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int prefix = 0;
        for(int num : nums) {
            prefix += num;
            ans += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}
