import java.util.*;
// Time Complexity: O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Core Idea
// We use a running sum to keep track of the total so far as we loop through the array.
// Current Running Sum = Previous Occured Running Sum + K
// Previous Occured Running Sum = Current Running Sum - K

class Solution {
    public int subarraySum(int[] nums, int k) {
        int rSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Here we put these values by default to handle the edge case 
        // if the array has [3, 4] 
        map.put(0, 1);

        for(int i=0; i < nums.length; i++) {
            rSum += nums[i];

            if(map.containsKey(rSum - k)) {
                count += map.get(rSum - k);
            } 
            
            if(!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }

        return count;
    }
}