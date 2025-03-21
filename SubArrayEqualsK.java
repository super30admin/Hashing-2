import java.util.HashMap;
// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 We use a running sum (rSum) to keep track of the sum from the start up to a given point. While calculating, if we find the complement (rSum - k) in the hashmap, it means we have found a subarray with sum equal to k. The value stored in the hashmap tells us how many times that complement has occurred, which we add to our count.

 Next, we check if rSum is already present in the hashmap:

 If it exists, we increment its count.
 Otherwise, we add it as a new entry.
 This ensures that we efficiently count all valid subarrays using a single pass and constant-time lookups.*/

class SubArrayEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int rSum = 0;

        //base case
        ///if zero has occurred before that means from start till a point we found
        //one array
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];

            int cmp = rSum - k;
            if (map.containsKey(cmp)) {
                count += map.get(cmp);

            }

            if (map.containsKey(rSum)) {
                map.put(rSum, map.get(rSum) + 1); // If rSum exists, increase its count
            } else {
                map.put(rSum, 1); // If rSum is not in the map, add it with count 1
            }
        }

        return count;
    }
}