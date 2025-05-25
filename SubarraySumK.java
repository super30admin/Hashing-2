import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    /**
     * Running sum and hashing pattern. We can find count of target (runningsum - k) if present
     * and add to result and add runningsum counts as key value pair.
     *
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        idxMap.put(0, 1); // 0 runningsum already happened before index 0
        int runningSum = 0;
        int result = 0;

        for (int num: nums) {
            runningSum += num;
            if (idxMap.containsKey(runningSum - k)) { //find target counts
                result += idxMap.get(runningSum - k);
            }

            if (idxMap.containsKey(runningSum)) {
                idxMap.put(runningSum, idxMap.get(runningSum) + 1);
            } else {
                idxMap.put(runningSum, 1);
            }
        }
        return result;
    }
}
