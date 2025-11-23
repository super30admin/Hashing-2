// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Maintain a running prefix sum and store how many times each prefix appears.
// For each position, if (prefix − k) exists, then subarrays ending at this index sum to k.
// Accumulate counts and update the prefix frequency map.

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int prefix = 0;
        int res = 0;
        for (int num : nums) {
            prefix += num;
            if (prefixSums.containsKey(prefix - k)) {
                res += prefixSums.get(prefix - k);
            }
            prefixSums.put(prefix, prefixSums.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
