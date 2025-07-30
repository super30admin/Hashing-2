// Time Complexity: O(n) 
// Space Complexity: O(n)
// Did this code successfully run on Leetcode? Yes
// Any problem you faced while coding this? No

// Approach:
// We use a running sum (rsum) and a HashMap to store the frequency of each prefix sum encountered so far.
// At each step, we check if (rsum - k) exists in the map. If it does, it means there is a subarray ending at the current index with sum k.
// We update the result count accordingly, and store the current rsum in the map with its frequency.

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>(); // rsum : count
        map.put(0, 1);

        int rsum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            rsum = rsum + nums[i];

            if(map.containsKey(rsum - k)){
                ans = ans + map.get(rsum - k);
            }

            if(map.containsKey(rsum)){
                map.put(rsum, map.get(rsum) + 1);
            }else{
                map.put(rsum, 1);
            }
        }
        return ans;
    }
}
