// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        for(int i =0 ; i<n;i++){
            int diff = k-nums[i];
            if(map.containsKey(nums[i])){
                count++;
            }
            map.put(diff,nums[i]);
        }
        return count;
    }
}