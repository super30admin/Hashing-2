// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max =0;
        int rsum =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<len;i++){
            if(nums[i]==0) rsum = rsum-1;
            else rsum = rsum + 1;
            if(!map.containsKey(rsum)){
                map.put(rsum, i);
            }
            else{
                int curr = i - map.get(rsum);
                max = Math.max(curr,max);
            }
        }
        return max;
    }
}