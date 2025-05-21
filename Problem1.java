//Problem: Subarray Sum Equals K
// Time Complexity : O(n), all hashmap operationd are average O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int rsum =0;
        for(int i=0; i<nums.length;i++){
            rsum += nums[i];
            if(map.containsKey(rsum - k)){
                count += map.get(rsum - k);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum, 0);
            }
            map.put(rsum, map.get(rsum) +1);
        }
        return count;
    }
}


