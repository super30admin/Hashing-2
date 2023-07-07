// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : looked at video again. 

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int rSum =0;
        int count = 0;
        map.put(rSum, 1);

        for(int i =0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            int complement = rSum - k;
            if(map.containsKey(complement)) {
                count = count + map.get(complement);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum, 1);
            }
            else {
                map.put(rSum,map.get(rSum)+1);
            }
            
        }

        return count;
    }
}
