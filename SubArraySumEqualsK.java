// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Using same running sum pattern approach

import java.util.HashMap;

public class SubArraySumEqualsK {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;
            map.put(0, 1);
            for(int i = 0; i<nums.length; i++){
                sum = sum + nums[i];
                if(map.containsKey(sum-k)){
                    count = count + map.get(sum-k);
                }
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum)+1);
                }
                else {
                    map.put(sum, 1); }
            }
            return count;
        }
}
