// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.Map;

class ContiguousBinaryArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // inserted to handle edge case: in order to include from the starting index
        
        int max = 0; // max length of the contiguous array
        int runningSum = 0; //Keeps track to sum to reach the index
        
        for(int i = 0; i<= nums.length -1; i++) {
            if(nums[i] == 0) {   // If element is 0 subtract 1 from the running sum else add one
                runningSum--;
            } else {
                runningSum++;
            }
            
            if(map.containsKey(runningSum)) { //if key already exists check the Max length
                max = Math.max(max, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        
        return max;
    }
}