// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Good follow up question if the array contains -ves

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //map to keep track of y(compliment) (z = x - y) and the freq
        HashMap<Integer, Integer> map = new HashMap<>();

        // add a dummy node to handle the edge case
        map.put(0, 1);
        int rSum = 0;

        // calculate running sum and increase the freq if you have seen the compliment before
        for(int i = 0; i < nums.length; i++){
            rSum += nums[i];
            int cmp = rSum - k;
            if(map.containsKey(cmp)){
                count += map.get(cmp);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return count;
    }
}