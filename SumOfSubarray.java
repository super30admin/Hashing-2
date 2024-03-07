// Time Complexity : O(n) where n is length of array
// Space Complexity : O(n) where n is length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach:
   keep calculating the rSum while traversing the array. keep a map to store the rSum and it's frequency
   calculate the difference of target and rSum
   if difference exists previously in the map, pull the value and add it to count
   add/update the rSum values to the map as they keep coming while the traversal.
*/ 
class SumOfSubarray {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        int count = 0;
        int rSum = 0;
        for ( int i =0; i < nums.length; i++){
            rSum += nums[i];
            int y = rSum - k;
            if(m.containsKey(y)){
                count += m.get(y);
            }
            if(!m.containsKey(rSum)){
                m.put(rSum,1);
            }else{
                m.put(rSum,m.get(rSum)+1);
            }
        }
        return count;
    }
}