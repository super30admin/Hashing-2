// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: understood problem
// Summary: calculating and storing the largest differnce between two same running sum

class Solution {
    public int findMaxLength(int[] nums) {
        
        if(nums == null || nums.length ==0) return 0;  
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 0){
                rSum = rSum - 1;
            }else{
                 rSum = rSum + 1;
            }
            
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));//difference in index is max length 
            }else{
                map.put(rSum,i);
            }
        }
        
        return max;
    }        
}
