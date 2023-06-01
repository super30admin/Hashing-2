// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

//Implementation using rsum
class Solution {
    public int findMaxLength(int[] nums) {
        //base case
        if(nums.length == 0 || nums == null) return 0;
        //store rsum as key and index as value in the hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);// to cover scenarios for array [0,1],[0,1,1,0],[0,1,0,1]
        int max = 0;
         int rsum = 0;
        for(int i=0;i<nums.length;i++){
            //if you encounter 1 you add 1 to rsum and subtract 1 when you encounter 0
            if(nums[i]==1){
                rsum++;
            }
            else{
                rsum--;
            }
            if(!map.containsKey(rsum)){
             map.put(rsum,i);
            }
            else{
                //update the maximum only if you get better max value in the current iteration
                 max = Math.max(max, i - map.get(rsum));
            }
        }
        return max;
        
    }
}