//Time Complexity : O(n)
//Space Complexity : O(n)

import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hmap = new HashMap<>(); 

        hmap.put(0,1);
        int count = 0; 
        int rSum = 0;

        for(int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            int complement = rSum -k;
            if(hmap.containsKey(complement)) {
                count += hmap.get(complement);
            }
            hmap.put(rSum, hmap.getOrDefault(rSum,0)+1);
        }

        return count;
    }
}