// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * "Running sum" algo can be used here. Store running sum at each stage in a hashmap with its frequency. Check if a key with
 * sum-k is present in the hashmap. If yes, then there is a subarray with sum k at that stage. Add the frequency of sum-k to the
 * count.
 */


class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int n: nums) {
            sum += n;
            int diff = sum - k;

            if(map.containsKey(diff))
                count += map.get(diff);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}