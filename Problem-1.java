// Time Complexity =O(n)
// Space Complexity - O(1)
// solved in leetcode - Yes
// faced any issues - No
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int rSum = 0, count = 0;

        // Base case: sum = 0 has one occurrence
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            rSum += num;

            // Check if there is a prefix sum that would make the subarray sum to k
            int x = rSum - k;
            if (prefixSumCount.containsKey(x)) {
                count += prefixSumCount.get(x);
            }

            // Update the prefix sum count
            prefixSumCount.put(rSum, prefixSumCount.getOrDefault(rSum, 0) + 1);
        }

        return count;
    }
}
