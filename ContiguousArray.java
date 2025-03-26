//Time Complexity : O(n)

//Space Complexity : O(n)

import java.util.*;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> hmap = new HashMap();
        int res = 0;
        hmap.put(0, 1);
        int rSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rSum -= 1;
            } else {
                rSum += 1;
            }

            if (rSum == 0) {
                res = i + 1;
            } else if (hmap.containsKey(rSum)) {
                res = Math.max(res, i - hmap.get(rSum));
            } else {
                hmap.put(rSum, i);
            }
        }
        return res;
    }
}