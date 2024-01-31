import java.util.HashMap;
import java.util.Map;

// Time Complexity - O(N)
// Space Complexity - O(N)

// Constraints:
// 1 <= nums.length <= 10^5
// nums[i] is either 0 or 1.

public class ContiguousArrayWithEqualZerosAndOnes {
    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> sumToIndexMap = new HashMap<>();
            int sum = 0;
            int maxLen = Integer.MIN_VALUE;

            sumToIndexMap.put(0, -1); //Dummy Value to include subarray starting from 0 -> [1,0]
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 1 ? 1 : -1;
                if (sumToIndexMap.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - sumToIndexMap.get(sum));
                } else {
                    sumToIndexMap.put(sum, i);
                }
            }
            return maxLen;
        }
    }
}
