import java.util.HashMap;

/**
 * TC: O(n)
 * SC: O(n) - space to store running sum and count in hashmap
 */
public class ContiguousArray {

        public int findMaxLength(int[] nums) {

            if (nums.length == 1) {
                return 0;
            }

            HashMap<Integer, Integer> keyCountMap = new HashMap<>();

            int max = 0;
            int keyVal = 0;

            int count = 0;
            nums[0] = nums[0] == 0 ? -1 : 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[i - 1] - 1;
                } else {
                    nums[i] = nums[i - 1] + 1;
                }
            }

            keyCountMap.put(0, -1);

            for (int i = 0; i < nums.length; i++) {

                if (keyCountMap.containsKey(nums[i])) {
                    max = Math.max(max, i - keyCountMap.get(nums[i]));
                } else {
                    keyCountMap.put(nums[i], i);
                }
            }

            return max;

        }
}
