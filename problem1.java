// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * we are keeping sum and itterating over the sum
 * when ever a new element ccome we add it to the sum and then, subtract k from it, and try to find that result in the map if it is there we add that number
 * to the sum and update the value in the map or else we add it the sum and 1 to the map
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        int totalSubarray = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            if (map.containsKey(rsum - k)) {
                totalSubarray += map.get(rsum - k);

            }
            if (map.containsKey(rsum)) {
                map.put(rsum, map.get(rsum) + 1);
            } else {
                map.put(rsum, 1);
            }
        }
        return totalSubarray;
    }
}