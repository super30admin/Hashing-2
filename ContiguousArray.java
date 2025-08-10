
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int maxLen = 0;
        int rSum = 0;

        Map<Integer, Integer> valueToIndexMap = new HashMap();
        valueToIndexMap.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                rSum = rSum - 1;
            } else {
                rSum = rSum + 1;
            }

            if (valueToIndexMap.containsKey(rSum)) {
                maxLen = Math.max(maxLen, i - valueToIndexMap.get(rSum));
            } else {
                valueToIndexMap.put(rSum, i);
            }
        }
        return maxLen;
    }
}