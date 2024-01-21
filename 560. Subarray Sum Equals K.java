// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> compIdx = new HashMap<>();
        int result = 0;

        compIdx.put(nums[0], 1);
        if(nums[0] == k) result = 1;

        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
            if(nums[i] == k) result++;
            if(compIdx.containsKey(nums[i]-k)){
                result += compIdx.get(nums[i]-k);
            }
            compIdx.put(nums[i], compIdx.getOrDefault(nums[i], 0) + 1);
        }

        return result;  
    }
}
