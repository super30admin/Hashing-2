import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0)
            return 0;
        int numOfSubArrayWithSumK = 0;
        int runningSum = 0;
        Map<Integer, Integer> runningSumCountMap = new HashMap<>();
        runningSumCountMap.put(0, 1);
        for (int index = 0; index < nums.length; index++) {
            runningSum = runningSum + nums[index];
            int compliment = runningSum - k;
            if (runningSumCountMap.containsKey(compliment)) {
                numOfSubArrayWithSumK = numOfSubArrayWithSumK + runningSumCountMap.get(compliment);
                // runningSumCountMap.put(runningSum, runningSumCountMap.get(runningSum) + 1);
            }

            if (runningSumCountMap.containsKey(runningSum)) {
                runningSumCountMap.put(runningSum, runningSumCountMap.get(runningSum) + 1);
            } else {
                runningSumCountMap.put(runningSum, 1);
            }

        }
        return numOfSubArrayWithSumK;

    }
}
