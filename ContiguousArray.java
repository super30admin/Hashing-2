// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class ContiguousArray {
        public int findMaxLength(int[] nums) {
            int cnt = 0;
            int rSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0,-1);
            int maxlen = 0;
            for (int num : nums){
                if (num == 0) rSum = rSum -1;
                else rSum = rSum + 1;
    
                if (map.containsKey(rSum)){
                    maxlen = Math.max(maxlen, cnt - map.get(rSum));
                } else {
                    map.put(rSum, cnt);
                }
                cnt++;
            }
            //System.out.println(map);
            return maxlen;
            
        }
    
}
