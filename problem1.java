// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// we use map to maintain (rsum, frequency of rsum). If rsum-k is found in map, we update the total count by adding that frequency to it.
// we keep checking rsum in map and update it by incrementing its frequency by 1. 
// The problem in this approach is we will miss one count if we have a subarray that starts from beginning of array. to avoid that we put (0,1) in the map.
// so that , whenever we get that situation, 1 will be added.

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int rsum = 0;
        int total=0;
        for(int i =0;i<nums.length;i++)
        {
            rsum+=nums[i];
            int p = rsum-k;
            if(map.containsKey(p))
            {
                total+= map.get(p);
            }
            map.put(rsum, map.getOrDefault(rsum,0) + 1);
        }
        return total;
    }
}