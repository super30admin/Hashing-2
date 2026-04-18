// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rsum = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            rsum = rsum + nums[i];
            if(map.containsKey(rsum-k)){
                count = map.get(rsum-k) + count;
            }
            if(!map.containsKey(rsum)){
                map.put(rsum, 1);
            }else{
                map.put(rsum,map.get(rsum) + 1);
            }
        }
        return count;
    }
}