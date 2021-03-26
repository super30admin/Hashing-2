
// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                rSum--;
            }else{
                rSum++;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}
}