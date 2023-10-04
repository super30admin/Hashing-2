// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int rSum = 0;
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int i;
        int total=0;
        sumMap.put(0,1);
        
        for(i=0; i<nums.length; i++){
            
            rSum += nums[i];
            if( sumMap.containsKey(rSum - k))
            total = total + sumMap.get(rSum - k);
           
            if(sumMap.containsKey(rSum)){
            sumMap.put(rSum,sumMap.get(rSum)+ 1);
            }
            else{ 
            sumMap.put(rSum,1);
            }
   
        }

return total;    

    }
}
