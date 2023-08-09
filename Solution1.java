// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
        int rSum = 0;
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>(); // rsum and frequency
        map.put(0,1); // to avoid excluding of starting subarray 
         for(int i=0; i<nums.length; i++){
             rSum+=nums[i];
             int comp = rSum-k;
             if(map.containsKey(comp))
             {
                 count+= map.get(comp);
             }
             if(map.containsKey(rSum)) //check if rSum is already there if so increase frequency
             map.put(rSum, map.get(rSum)+1);
             else 
             map.put(rSum,1);
         }
         return count;
    }
}