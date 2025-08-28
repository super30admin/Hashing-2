// array is balanced when you have equal number of 0's and 1's
// concept of if you have x and z you can find y
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;

        // dummy node to handle the edge case where the balanced subarray starts from 0th index
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                rSum -= 1;
            else
                rSum += 1;
            if(map.containsKey(rSum)){
                int temp = i - map.get(rSum); 
                max = Math.max(max, temp);
            }
            // we only want to keep the first or min index of where that running sum was actually seen and not all to get the longest balanced subarray
            else
                map.put(rSum, i);
        }
        return max;
    }   
}