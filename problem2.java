import java.util.HashMap;

// ## Problem2 (https://leetcode.com/problems/contiguous-array/)

class Solution {
    
    // Time : O(n)
    // Space : O(n)
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rsum = 0;
        int max = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) {
                rsum --;
            } else {
                rsum++;
            }
            if (map.containsKey(rsum)) {
                max = Math.max(max,i - map.get(rsum));
            } else {
                map.put(rsum,i);
            }
        }
        return max;
    }
}