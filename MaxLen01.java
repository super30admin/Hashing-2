// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.HashMap;

/**
 * Similar to prefix sum question. Take a map with sum to index mapping. 
 * Iterate over the array and at each index, add the value (for 1, +1 and for 0, -1).
 * Now, check if the sum is 0. If so, then there are equal number of 0s and 1s till there.
 * Update max length. If sum is not 0 and already present in the map, get the index of that 
 * count and check max(maxLen, index i - index of that count). If sum not found, then
 * put it in the map for future use. Return the maxLen.
 *
 */
public class MaxLen01 {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if (count == 0)
				maxLen = i + 1;
			else if (map.containsKey(count))
				maxLen = Math.max(maxLen, i - map.get(count));
			else
				map.put(count, i);
		}
		return maxLen;
	}
}
