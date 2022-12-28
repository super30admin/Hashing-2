// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//560. Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int rSum = 0;
        int count = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        map.put(rSum, 1);
        for(int i = 0; i < nums.length; i++){
            rSum += nums[i];
            if(map.containsKey(rSum - k)){
                count += map.get(rSum - k);
            }
            // int a = 1;
            // if(map.containsKey(rSum)){
            //     a = map.get(rSum) + 1;
            // }
            // map.put(rSum, a);
            map.put(rSum, map.getOrDefault(rSum,0) + 1);
        }
        return count;
    }
}