/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)  
* 
* Space Complexity: O(n) ->  26 

Approach:
1. 

 */

 class Solution {
    public int subarraySum(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0,1);
      int rsum = 0;
      int count = 0 ;
      for(int i=0; i < nums.length; i++)
      {
         rsum += nums[i];

         if(map.containsKey(rsum - k))
            count += map.get(rsum - k);
        
         map.put(rsum, map.getOrDefault(rsum, 0) + 1);
         
      }
       return count;
    }
}