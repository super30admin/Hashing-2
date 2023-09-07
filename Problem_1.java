/*
 
Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Using runing sum along with hashmap to store the sum along with the count. If rSum - target is present in the map
then add the count next to it and increment it by 1.

*/

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> rMap = new HashMap<>(); 
        rMap.put(0,1);
        int rCount = 0;
        int rSum = 0;
        for(int i = 0; i < nums.length; i++){
            rSum = rSum + nums[i];
            int key = rSum - k;
            if(rMap.containsKey(key))
            {
                rCount = rCount + rMap.get(key);
            }
            rMap.put(rSum, rMap.getOrDefault(rSum, 0) + 1);
        }
        return rCount;
    }
}
