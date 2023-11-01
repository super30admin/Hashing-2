// Time Complexity : O(N) where N is length of input array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SubArraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k)
        {
            int count = 0;
            int runningSum = 0;
            HashMap<Integer, Integer> map = new HashMap();
            map.put(0, 1);

            for(int element : nums)
            {
                runningSum += element;
                int key = runningSum-k;
                if(map.containsKey(key))
                {
                    count += map.get(key);
                }

                map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
            }

            return count;
        }
    }
}
