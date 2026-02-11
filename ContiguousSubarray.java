import java.util.*;

// O(n) time, O(n) space
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int runninSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // edge case when runningSum is 0 initially, should be at -1 idx

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                runninSum--;
            }
            else {
                runninSum++;
            }

            if (map.containsKey(runninSum)) {
                maxLen = Math.max(maxLen, i - map.get(runninSum));
            }
            else {
                map.put(runninSum, i);
            }
        }
        return maxLen;
    }
}