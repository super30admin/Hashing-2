import java.util.*;

// O(n) time, O(n) space
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // initially runningSum has freq of 1

        int count = 0;
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            int complement = runningSum - k;

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}