// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Determining the dummy value

// Your code here along with comments explaining your approach - Running Sum Approach
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int rsum = 0;

        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            int comp = rsum - k;

            if (map.containsKey(comp)) {
                count += map.get(comp);
            }

            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }

        return count;

    }
}