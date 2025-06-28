// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//approach: keep a running sum as we iterate through the array and use a hash map to store how often each sum has occurred. For each element, we check if the difference between the current running sum and k has been seen before and if yes, it means a subarray with sum k exists ending at the current index. We count all such valid subarrays using this method.

import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int rSum=0;
        int count =0;
        HashMap<Integer,Integer> map= new HashMap<>();
         map.put(0,1);

        for(int i=0;i<nums.length;i++){
            rSum= rSum+nums[i];

            if(map.containsKey(rSum-k)){
                count = count+map.get(rSum-k);

            } 
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return count;
        
    }
}