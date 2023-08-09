// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int subarraySum(int[] nums, int k) {
    
        HashMap<Integer,Integer> map = new HashMap<>();

        int rSum=0; 
        int count=0;
        map.put(0,1);
       
        // similar to contiguous array but here need to store the freq
        for (int i=0; i<nums.length;i++){
            rSum += nums[i];
            int cmp = rSum-k;
            if(map.containsKey(cmp)){
                count+=map.get(cmp);
            }
            if(map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }else{
                map.put(rSum,1);
            }
        }
        return count;
    }
}


