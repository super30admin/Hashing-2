import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code run on leetcode? : Yes
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        int maxLength = 0;

        Map<Integer, Integer> runningSum = new HashMap<>();
        int sum = 0;

        runningSum.put(sum, -1);

        for(int i = 0; i < nums.length; i++) {
            // Increment 1 when nums[i] = 1;
            // decrement 1 when nums[i] = 0;
            // so that any given pair of 1 and 0 sums up to 0.
            sum += (nums[i] == 0 ? -1 : nums[i]);

            // If I've seen this runningSum already, then it means that
            // array between that index and current index sums up to 0, i.e.
            // has equal no. of 0's and 1's
            if(runningSum.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - runningSum.get(sum));
            } 
            // If I'm seeing my running sum for the first time, mark it's index
            else {
                runningSum.put(sum, i);
            }
        }

        return maxLength;
    }
}