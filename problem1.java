import java.util.HashMap;

// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

class Solution {
    
    // tc: O(n)
    // sc: O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rsum = 0;
        int result = 0;
        for (int i = 0; i< nums.length; i++) {
            rsum += nums[i];
            if (map.containsKey(rsum-k)) {
                result = result + map.get((rsum-k));
            }
            if (!map.containsKey(rsum)) {
                map.put(rsum,0);
            }
            map.put(rsum,map.get(rsum)+1);
        }
        return result;
    }
}