import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code run on leetcode? : Yes
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> runningSum = new HashMap<>();
        int sum = 0;

        // Initially the sum would be 0, hence we store this saying
        // we have seen the runningSum to be 1 once.
        runningSum.put(sum, 1);

        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If I've seen a subarray before with runningSum = sum - k,
            // it means subarray in between adds up to k, hence we
            // add to our count the no. of times we have seen "sum - k"
            if(runningSum.containsKey(sum - k)) {
                count += runningSum.get(sum - k);
            }

            // Frequency of times we have seen "sum"
            runningSum.put(sum, runningSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}