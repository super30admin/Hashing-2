import java.util.HashMap;

/**
 * TC: O(n)
 * SC: O(n) - space to store running sum and count in hashmap
 */
class Solution {
    public int subarraySum(int[] nums, int k) {

        int runningSum = 0, count = 0;

        HashMap<Integer, Integer> runningSumCountMap = new HashMap();

        runningSumCountMap.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (runningSumCountMap.containsKey(runningSum - k)) {
                count += runningSumCountMap.get(runningSum - k);

            }
            runningSumCountMap.put(runningSum, runningSumCountMap.getOrDefault(runningSum, 0) + 1 );

        }

        return count;
    }
}