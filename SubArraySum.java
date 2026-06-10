import java.util.HashMap;

class Solution {
    /*
    TC - O(n)
    SC - O(n)
    Solution - Go through the array and record the running sum (add up values at indexes) 
    and add the running sum in the map with count as 1. If the running sum already exists, 
    increment the count in the map. Calculate the difference between the running sum at current index 
    and the target sum k. If the difference exists in the map, increase count by the frequency mapped
    to the difference value in map. Return the count.
    */
    public int subarraySum(int[] nums, int k) {
        int rsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            if (map.containsKey(rsum - k)) {
                count += map.get(rsum - k);
            }

            if (map.containsKey(rsum)) {
                map.put(rsum, map.get(rsum) + 1);
            } else {
                map.put(rsum, 1);
            }
        }

        return count;
    }
}