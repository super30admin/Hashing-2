//Time Comlexity : O(n)
//Space Complexity : O(n)

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0,-1);
        int sum = 0;
        int longest = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if(count.containsKey(sum)) {
                int idx = count.get(sum);
                longest = Math.max(longest, i - idx);
            } else {
                count.put(sum, i);
            }
        }
        return longest;
    }
}
