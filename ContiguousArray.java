import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * https://leetcode.com/problems/contiguous-array/
 * 
 * We are reducing the O(n3) time complexity to O(n) by using the running sum
 * pattern.
 * 
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        if (nums.length == 1)
            return 0;
        int runningSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> runningSumVsFirstOccurance = new HashMap<>();
        runningSumVsFirstOccurance.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + (nums[i] == 1 ? 1 : -1);
            if (runningSumVsFirstOccurance.get(runningSum) == null) {
                runningSumVsFirstOccurance.put(runningSum, i);
            } else
                maxLength = Math.max(i - runningSumVsFirstOccurance.get(runningSum), maxLength);
        }
        return maxLength;
    }
}
