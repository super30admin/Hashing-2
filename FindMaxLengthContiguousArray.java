// Time Complexity : O(N) where N is length of input array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMaxLengthContiguousArray
{
    class Solution {
        public int findMaxLength(int[] nums)
        {
            int runningSum = 0;
            HashMap<Integer, Integer> map = new HashMap();
            map.put(0, -1);
            int maxLength = 0;
            for(int i = 0; i< nums.length; i++)
            {
                runningSum += (nums[i] == 0) ? -1 : 1;
                if(map.containsKey(runningSum))
                    maxLength = Math.max(maxLength, i-map.get(runningSum));
                else
                    map.put(runningSum, i);

            }
            return maxLength;
        }
    }
}