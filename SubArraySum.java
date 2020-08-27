package com.Aug2020.Hashing2;

import java.util.HashMap;
import java.util.Map;

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//logic behind this was bit tricky to formulate.

public class SubArraySum {
	 public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        int sum = 0;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	          map.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if (map.containsKey(sum - k)) {
	                count += map.get(sum - k);
	             }
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	           
	        }
	        return count;
	    }
}
