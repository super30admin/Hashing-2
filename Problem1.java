// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach: Count earlier prefixes equal to rsum - k,
//then record the current rsum.
//map.put(0, 1) covers subarrays starting at index 0.

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        map.put(0,1);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum - k)){
                count = count + map.get(rSum-k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0)+1);
        }
        return count;
    }
}