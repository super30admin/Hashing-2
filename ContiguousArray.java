// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
        int maxlen = 0;
        // store running sum first occurances - add -1 for 0's and +1 for 1's
        HashMap<Integer, Integer> map = new HashMap<>();
        // key is runningsum and value is index of first occurance if the running sum
        int runningsum = 0;
        map.put(runningsum, -1);
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                runningsum--;
            }
            else
            {
                runningsum++;
            }
            if(map.containsKey(runningsum))
            {
                maxlen = Math.max(maxlen, i - map.get(runningsum));
            }
            else // coz we want to preserve index of first occurance of the runningsum
            {
                map.put(runningsum, i);
            }
        }
        return maxlen;
    }
}