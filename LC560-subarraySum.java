import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //  brute force: get all possible subarrays and check if sum equals to k or not

        // Lets try running sum method. 
        /*
        lets say target = 3 
        array = [1,3]
        rsum = [1,4] , if rsum-target = 1 happend , then possible array = 1
        
        array = [1,3,0]
        rsum = [1,4,4] , 
            at i=1 rsum(4)-target(3) = 1 happend once, then possible array = 1
            at i=2 rsum(4)-target(3)=1 happend once, then possible array = 1+1 = 2

        array = [1,3,0,-1]
        rsum =  0:1[1,4,4, 3], 
            at i=1 rsum(4)-target(3) = 1 happend once, then possible array = 1
            at i=2 rsum(4)-target(3)=1 happend once, then possible array = 1+1 = 2
            at i=3 rsum(3)-target(3)=0 happend once, then possible array = 1+1+1 = 3
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // if sum of all is 0
        int count = 0; // 
        int rsum = 0;
        for (int i=0; i<nums.length; i++) {
            rsum += nums[i];

            if (map.containsKey(rsum-k)) {
                count += map.get(rsum-k);
            }

            if (!map.containsKey(rsum)) map.put(rsum, 0);

            map.put(rsum, map.get(rsum)+1);
        }

        return count;

    }
}
