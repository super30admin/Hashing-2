import java.util.*;

public class SubArraySumK {
    // TC: O(N), where N is the size of array
    // SC: O(N), where N is the size of array
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> runningSumFreq = new HashMap<>();
        runningSumFreq.put(0, 1);
        int runningSum = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int complement = runningSum - k;
            if (runningSumFreq.containsKey(complement)) {
                res += runningSumFreq.get(complement);
            }
            runningSumFreq.put(runningSum, runningSumFreq.getOrDefault(runningSum , 0) + 1);
        }
        return res;
    }
}
