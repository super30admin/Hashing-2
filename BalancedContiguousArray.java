// Time Complexity : O(N) -- as traversing the array once
/* Space Complexity : O(N) -- as in worst case need to store N elements in
HashMap
*/ 
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Had to go through the logic 
again which was discussed in class*/


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        // HashMap to store (runningSum:index)
        HashMap<Integer,Integer> map = new HashMap<>(); 
        /* to tackle the edge case of missing out on first
         occurence of balance subarray e.g. {1,0} 
         */
        map.put(0,-1); 
        int rSum = 0; int max = 0; int target = 0; // here target means when the running sum of a subarray is 0 -- which indicates that the subarray is balanced
        for(int i=0;i<nums.length;i++){
            // Increment rSum by 1 if element is 1 and decrement by 1 if element is 0
            if(nums[i] == 1){
                rSum = rSum + 1;
            }else if(nums[i] == 0){
                rSum = rSum - 1;
            }
            /* Check whether diference between rSum at current index 
            and the target is equal to the index value stored in map.
            Yes then store the max length where length is the value between 
            current and the previous found index. If no then add rSum and index 
            to the map 
            */ 
            if(map.containsKey(rSum - target)){
                max = Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}