import java.util.HashMap;

public class SubarraySumEqualK {
    // Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                result = result + map.get(sum - k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);
        }
        return result;
    }
}
