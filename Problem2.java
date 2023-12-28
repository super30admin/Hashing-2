/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n) -> 
* 
* Space Complexity: O(n) ->   

Approach:
1. 0: count decraese by 1
   1: count increase by 1

2. we will store the running_sum and least/first - index in hashmap
3.  If the running_sum found in hashmap:  (store running_sum in hashMap)
  then the subarray is balanced.
4. 

*/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int maxlength = 0;
        int rsum =0 ;
        hmap.put(0,-1);
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) rsum--;
            else rsum++;

            if(hmap.containsKey(rsum))
            {
                int currlength = i - hmap.get(rsum);
                maxlength = Integer.max(maxlength, currlength); 
            }else{
                hmap.put(rsum,i);
            }
        }
        return maxlength;
    }
}