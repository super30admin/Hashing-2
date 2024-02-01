// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach : Used runningsum technique 

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0; // max length of balanced binary array
        int rSum = 0; 
        map.put(rSum,-1); // to mark the initial rSum as dummy entry to catch the balanced binary array starting from 0

        for(int i = 0; i < nums.length ; i++){
            rSum = nums[i] == 1 ? rSum+1 : rSum-1; // if n = 1 add 1, if 0 minus 1

            // maxlength = rSum of current index and the rSum found earliest index
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else{
                map.put(rSum, i);
            }
        }

        return max;
    }
}