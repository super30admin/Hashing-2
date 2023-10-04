// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class SubArraySumK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, runningSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            for(int i = 0; i < nums.length; i++){
                runningSum += nums[i];

                if(map.containsKey(runningSum - k)){
                    count += map.get(runningSum - k);
                }
                map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
            }
            return count;
        }
    }
}
