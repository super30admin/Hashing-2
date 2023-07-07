// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : watched video again

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int runSum = 0;
        int max = 0;
        map.put(0, -1); 
        for(int i =0; i<nums.length;i++) {
            if(nums[i] == 0) runSum--;
            else runSum++;
            if(map.containsKey(runSum)) {
                max = Math.max(max, i-map.get(runSum));
            }else{
                map.put(runSum, i);
            }
        }
        return max;
        
    }
}