// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
If encountered 0 rSum decrement by 1, if 1, increment rSum by 0
If there exists an rSum in the hashmap then we would count the length based on the current idx and the value from the hmap
Update the length if it is greater.
 */

import java.util.*;

public class Problem2 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int rSum = 0;
        int maxLen = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == 0) {
                rSum -= 1;
            } else {
                rSum += 1;
            }

            if(hmap.containsKey(rSum)) {
                int totalLen = i - hmap.get(rSum);
                maxLen = Math.max(totalLen, maxLen);
            } else {
                hmap.put(rSum, i);
            }
        }

        return maxLen;
    }
}