import java.util.HashMap;
import java.util.Map;

// Time Complexity - O(N)
// Space Complexity - O(N)

// Constraints:
// 1 <= nums.length <= 2 * 10^4
// -1000 <= nums[i] <= 1000
// -10^7 <= k <= 10^7

// Array - [3, 4, 7,  2,  -3, 1,  4,  2,  0,  1]
// Sum   - [3, 7, 14, 16, 13, 14, 18, 20, 20, 21]
// MapVal- [1, 1, 1,  1,  1,  2,  1,  1,  2,  1]
// Count - [0, 1, 2,  2,  2,  3,  3,  4,  5,  7]
public class CountSubArraySumK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumToCountMap = new HashMap<>();
            int sum = 0;
            int count = 0;

            sumToCountMap.put(0, 1); // Dummy Value
            for (int currNum : nums) {
                sum += currNum;
                if (sumToCountMap.containsKey(sum - k)) {
                    count += sumToCountMap.get(sum - k);
                }

                // if (sumToCountMap.containsKey(sum)) {
                //    sumToCountMap.put(sum, sumToCountMap.get(sum) + 1);
                // } else {
                //    sumToCountMap.put(sum, 1);
                // }
                sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
