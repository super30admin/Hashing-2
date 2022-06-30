// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int rSum = 0;
        int tSum = 0;
        for(int i=0;i<nums.length;i++){
            rSum = rSum + nums[i];
            int diff = rSum - k;
            if(hm.containsKey(diff)){
                tSum = tSum + hm.get(diff);
            }
            if(hm.containsKey(rSum)){
                hm.put(rSum, hm.get(rSum) + 1);
            }
            else {
                hm.put(rSum,1);
            }
        }
        return tSum;
    }
}