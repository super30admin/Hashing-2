import java.util.*;
// Time Complexity : O(n) where n is the size of arr
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, the intuition for the time
// optimized solution was not clear


// Your code here along with comments explaining your approach

class Solution1 {
    public int subarraySum(int[] nums, int k) {
        //map to store prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0,1); //Case where we do not remove anything
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if( map.containsKey(sum-k) ) {
                count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}