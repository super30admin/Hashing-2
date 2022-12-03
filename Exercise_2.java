// Contiguous Array
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// Running sum pattern. Increse count 1 when encounter 1, and decrease count 1 when encounter 0. Like wise count the running sum.
// As we are doing search, will use a hashmap. running sum as key and 1st encountered index as value.
// Check if the running sum at this place if its happened before and at what index it has happened.
// We can say between current index & the earliest index where it (0) happened, the array between them is going to be balanced.


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //so that will not miss [0,1] case
        int runsum = 0;
        int result = 0;

        for(int i =0; i<nums.length; i++) {
            //calculate running sum
            if(nums[i] == 0)
                runsum--;
            else
                runsum++;

            if(map.containsKey(runsum)) {
                // balanced array found between current and that index
                int len = i - map.get(runsum);
                result = Math.max(result, len);
            }
            else {
                map.put(runsum, i);
            }
        }
        return result;
    }
}