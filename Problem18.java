// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: understood after rewatching class
// Summary: adding to count each time a running sum minus target is an existing running sum. also remember to add how many running
// 	    of the same runnning sums there are.

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums == null || nums.length ==0) return 0;  
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            rSum += nums[i];
            if(map.containsKey(rSum - k)){
                count += map.get(rSum - k);
            }
           
            if(!map.containsKey(rSum)){
                map.put(rSum,1);
            }else{
                map.put(rSum, map.get(rSum) + 1);
            }
            
        }
        return count;
    }
}
