// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// This problem can be done using running sum and a Hashmap
// we use hashmap to store the rsum and index
// at every number we check if the rsum is present as key 
// if it exists we take the max of max or the difference of the index and the value we get for the key

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int rsum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                rsum--;
            else
                rsum++;
            if (map.containsKey(rsum)) {
                max = Math.max(max, i - map.get(rsum));
            } else
                map.put(rsum, i);
        }
        return max;
    }
}