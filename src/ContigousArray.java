// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/contiguous-array/
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        //map to keep track of count and correspoding index
        Map<Integer, Integer> countMap = new HashMap<>();
        
        countMap.put(0, -1);
        
        int len = 0, countSoFar = 0;
        
        for(int i=0; i<nums.length; i++) {
            //increase count if 1 , decrease if 0 found
            if(nums[i] == 1) {
                countSoFar++;
            }else {
                countSoFar--;
            }
            
            //if same count is found before, current index and that index will give contigous array
            if(countMap.containsKey(countSoFar)) {
                len = Math.max(len, i - countMap.get(countSoFar));
            } else
            {
                countMap.put(countSoFar, i);
            }
        }
        
        return len;
    }
}