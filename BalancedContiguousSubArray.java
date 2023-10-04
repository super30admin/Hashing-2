// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BalancedContiguousSubArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            int runningSum = 0, maxLen = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0) runningSum--;
                if(nums[i] == 1) runningSum++;

                if(map.containsKey(runningSum)){
                    int len = i - map.get(runningSum);
                    maxLen = Math.max(len, maxLen);
                }
                else{
                    map.put(runningSum, i);
                }
            }
            return maxLen;
        }
    }
}
