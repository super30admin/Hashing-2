// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
I will have an rSum, I will calculate the difference between rSum and k.
Once I calculate the diff I will check if the diff exists in hashMap.
I will add the value of the diff from the hashmap.
 */


import java.util.*;

public class Problem1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);

        int rSum = 0;
        int ans = 0;
        for(int i = 0;i<nums.length;i++) {
            rSum += nums[i];
            int diff = rSum - k;
            if(hmap.containsKey(diff)) {
                ans += hmap.get(diff);
            }

            hmap.put(rSum, hmap.getOrDefault(rSum, 0) + 1);
        }

        return ans;
    }
}