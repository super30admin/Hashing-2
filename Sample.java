// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> compIdx = new HashMap<>();
        int result = 0;

        nums[0] = nums[0] == 1 ? 1 : -1;
        compIdx.put(nums[0], 0);
        if(nums[0] == 0) result = 1;

        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + (nums[i] == 1 ? 1 : -1);
            if(nums[i] == 0){
                result = i+1;
            } else if(compIdx.containsKey(nums[i])){
                result = Math.max(result, i - compIdx.get(nums[i]));
            } else compIdx.put(nums[i], i);
        }

        return result;        
    }
}
