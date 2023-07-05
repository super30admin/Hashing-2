// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//to find the logest contiguous balanced subarray, running sum is calculated if 0 is encountered -1 and 1 is encountered +1. calculate the the max of defference of i index 
//and first occurance of the running sum else we update the hash map with running sum and the index at which the sum occured.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum =0;
        int max=0;
        map.put(0,-1);
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
            rSum--;
        }else{
            rSum++;
        }
        if(map.containsKey(rSum)){
            max = Math.max(max, i-map.get(rSum));
        }else{
            map.put(rSum,i);
        } 
      
    }
      return max;
}
}