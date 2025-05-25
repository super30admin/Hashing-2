import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    // ----------------------------- Solution 1 ---------------------------
    /**
     * Brute force
     * Time O(n^2) Space O(1)
     */
    public int findMaxLength1(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    max = Math.max(max, zeros + ones);
                }
            }
        }
        return max;
    }

    // ----------------------------- Solution 2 ---------------------------
    /**
     * Running sum and hashing pattern. In single iteration we will maintain a runningSum (add 1 if 1 is encountered,
     * subtract 1 when 0) and will keep a map tracking the first time/index when that running happened. We can eliminate
     * the nested array need by relying upon running sum pattern that if at 2 indices same running sum happened then in between
     * there is a balanced binary subarray.
     *
     * Time: O(n) Space: O(n)
     */
    public int findMaxLength2(int[] nums) {
        int runningSum = 0;
        Map<Integer, Integer> minIdxMap = new HashMap<>();
        minIdxMap.put(0, -1);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum = nums[i] == 0 ? runningSum - 1 : runningSum + 1;
            if (minIdxMap.containsKey(runningSum)) {
                max = Math.max(max, i - minIdxMap.get(runningSum));
            } else {
                minIdxMap.put(runningSum, i);
            }
        }
        return max;
    }
}
