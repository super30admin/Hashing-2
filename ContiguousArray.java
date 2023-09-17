// Time Complexity : O(n)
// Space Complexity : O(n) -Hashmap
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/contiguous-array/submissions/1047628082/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Maintain running sum of the binary array, such that subtract -1 whenever you find a 0, and add 1 whenever you find 1
// Maintain a hash map for the lookup, whenever the same running sum is found it indicates that there are equal number of 0’s and 1’s in that subarray , initialize hashmap with (0,-1) to consider contiguous array [0,1]
// Find the max value that can be attained through the subarrays, return the value 

import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int rsum =0;
        int max1 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i< nums.length ; i++){
            if(nums[i]==0)
                rsum-=1;
            else    rsum+=1;
            if(!map.containsKey(rsum))
                map.put(rsum, i);
          else
                max1 =  Math.max(max1, i-map.get(rsum));
        }
        return max1;
    }
}