// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * "Running sum" algo can be used here. Increment by sum 1 for every 1, and decrement by 1 for every 0. Whenever, there are
 * 2 index with the same sum, then we have a Contiguous array. Store the initial occurance of a sum in a hashmap with its index.
 * Further, at any stage if we get the same sum, then substract current and initial index and calculate max length.
 */

//Running Sum
class Solution {
    public int findMaxLength(int[] nums) {

        int max = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0)
                sum--;
            else
                sum ++;

            if(map.containsKey(sum))
                max = Math.max(max, i-map.get(sum));
            else
                map.put(sum, i);
        }

        return max;
    }
}