// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just had to convert 0 to -1.


// Your code here along with comments explaining your approach in three sentences only
// We treat 0 as -1 and 1 as +1 and keep a running sum.
// If the same sum appears again, the subarray between them has equal number of 0s and 1s.
// We store the first index of each sum in a hashmap to get the maximum length.

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) sum -= 1;
            else sum += 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
