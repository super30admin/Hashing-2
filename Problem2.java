import java.util.*;



// Time Complexity : O(n) where n is the size of arr
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, the intuition for the time
// optimized solution was not clear


// Your code here along with comments explaining your approach
// Running Sum Pattern. Increment the sum if nums[i] = 1 decrement otherwise,
// check if the running sum has been seen before using a HashMap



class Solution2 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        if( n == 1) {
            return maxLen;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum = 0;
        for(int i = 0; i < n; i++) {
            if( nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }
            if( !map.containsKey(rSum) ) {
                map.put(rSum, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(rSum));
            }
        }
        return maxLen;
    }
}