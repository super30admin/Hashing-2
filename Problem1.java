// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0,ans = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            rsum += nums[i];
            if(map.containsKey(rsum-k)){
                ans+=map.get(rsum-k);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return ans;
    }
}