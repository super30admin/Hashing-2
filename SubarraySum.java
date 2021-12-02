// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// This problem can be done using running sum and a Hashmap
// we use hashmap to store the rsum and no of times it occured
// at every number we calculate the rsum and subtract it with k 
// we see the if the difference exists as key in the map and take the value and add to the count

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return 0;
        int rsum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rsum = rsum + nums[i];
            if (map.containsKey(rsum - k))
                count = count + map.get(rsum - k);
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }
        return count;
    }
}