//Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        //runningSum
        int rSum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            rSum += nums[i];
            if(map.containsKey(rSum - k))
            {
                count += map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0)+1);
        }
        return count;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = new int[] {7,1,5,3,2,6,4,6};
        System.out.println(sol.subarraySum(array, 5));
        
    }
}