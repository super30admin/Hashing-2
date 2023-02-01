// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a hashmap to reduce our complexity of nested loops O(n^2) to O(n). We store rSum together with count of that sum encountered so far.We keep 
   track of a running sum and add to it the elements seen so far.Then we check if map contains a key (rSum - k), if we find such a key that means the 
   array between sum so far and rSum - k sums to k. We add the count of that key to our result. Once array is traversed we have the count of subarrays
   summing to k.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> hMap = new HashMap<>();

        hMap.put(0, 1);
        int rSum = 0;
        int result = 0;

        for(int i = 0; i < nums.length; ++i) {
            rSum += nums[i];
            if(hMap.containsKey(rSum - k))
                result += hMap.get(rSum - k);
            if(!hMap.containsKey(rSum))
                hMap.put(rSum, 0);
            hMap.put(rSum, hMap.get(rSum) + 1);
        }
        return result;
    }
}