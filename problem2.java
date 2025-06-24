// Time Complexity : O(n)
// Space Complexity : O(n) for the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I use +1 for 1 and -1 for 0, so that we can keep a count of the number of ones and zeroes seen so far.
// I use a HashMap to store the first index where each count was seen. If the count is zero, it means we have seen equal number of ones and zeroes from the start to the current index.
// if we seen this count before, equal number of ones and zeroes came up after that to balance it up so we can say that from that j to current i is balanced.
// else, we just put the count on the map, we keep the first seen one to maximize the length

import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        map.put(0,-1); // till before the array starts, it is balanced
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0)count--;
            else count++;
            if(count==0) res=i+1;
            else if(map.containsKey(count)) res = Math.max(res, i-map.get(count)); 
            else map.put(count, i);
        }
        return res;
    }
}
