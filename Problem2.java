//Problem2: Contiguous Array
//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
// Time Complexity : O(n), all hashmap operationd are average O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rsum =0;
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] ==0){
                rsum -= 1;
            }
            else{
                rsum +=1;
            }
            if(map.containsKey(rsum)){
                max = Math.max(max, i - map.get(rsum));
            }
            else{
                map.put(rsum, i);
            }
        }
        return max;
        
    }
}