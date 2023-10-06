
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0,ans = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==1)
                rsum++;
            else
                rsum--;
            if(map.containsKey(rsum)){
                ans = Math.max(ans,i - map.get(rsum));
            }
            else
            map.put(rsum,i);
        }
        return ans;
    }
}