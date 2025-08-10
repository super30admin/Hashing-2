
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prefixSum = 0;
        int count = 0;

        Map<Integer, Integer> prefixSumToCountMap = new HashMap();
        prefixSumToCountMap.put(0, 1);

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];

            if (prefixSumToCountMap.containsKey(prefixSum - k)) {
                count += prefixSumToCountMap.get(prefixSum - k);
            }
            prefixSumToCountMap.put(prefixSum, prefixSumToCountMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }
}