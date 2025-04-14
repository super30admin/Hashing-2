// we use hashmap to optimise the search
// if the complement exist inside the hashmap then produce a subarray
// if it does'nt exists store running sum inside it

// Time : O(n)
// Space : O(n)

// This code properly worked on leetcode.

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // rSum : count
        int rSum = 0; // taking zero initially
        map.put(0, 1); // rSum of zero happen once
        int result = 0;

        for(int num : nums) {
            rSum += num;
            int comp = rSum - k;// k is target and comp is complement
            if(map.containsKey(comp)) { // check whether this comp is happening as rSum or not
                result += map.get(comp); // times comp has happened
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
    return result;
        
    }
}