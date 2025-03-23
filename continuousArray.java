import java.util.*;
// Time Complexity: O(N) 
// Space Complexity: O(N), cause we can store every running sum in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Core Idea
// We use a running sum to keep track of the total so far as we loop through the array.
// If the same running sum (rSum) appears again, it means the numbers in between have balanced out to zero.
// Sub array length = current running sum index - if the running sum has already occured that index
class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int rSum = 0;  
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0) rSum --;
            else rSum ++;
        
            if(map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }

        return max;
    }
}