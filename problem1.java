// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int rsum = 0;
        map.put(0, 1);
        for(int i=0; i < nums.length; i++) {
            rsum = rsum + nums[i];
            if(map.containsKey(rsum - k)) {
                cnt = cnt + map.get(rsum - k);
            }
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }
        return cnt;
    }
}