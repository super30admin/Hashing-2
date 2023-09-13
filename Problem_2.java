/*
 
Problem2 (https://leetcode.com/problems/contiguous-array/)

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Using runing sum along with hashmap to store the sum along with the count. Consider +1 for 1 and -1 for 0, store the rSum
along with index, if we find the same rSum again then we can find the diff from the first index.

*/

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> runMap = new HashMap<>();
        runMap.put(0,-1); //To handle cases starting w 0
        int max = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num == 0){
                count--;
            }
            else{
                count++;
            }
            if(!runMap.containsKey(count)){
                runMap.put(count, i);
            }
            else{
                int len = i - runMap.get(count);
                max = len > max ? len : max; 
            }
        }
        return max; 
    }
}