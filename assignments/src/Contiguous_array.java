import java.util.HashMap;

public class Contiguous_array {
    // Time: O(n), Space: O(n)
    public int findMaxLength(int[] nums) {
        int count = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap();
        // count, index
        map.put(0,-1);

        for (int i = 0; i<nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
