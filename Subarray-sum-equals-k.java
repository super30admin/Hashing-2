// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  Yes https://leetcode.com/problems/subarray-sum-equals-k/submissions/1047874872/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1. Maintain running sum and count variable to maintain the count of the subarrays
// 2. Use a hashmap and maintain the keys as running sum and values as count whenever the runnigsum - target(k) exists, add to the count
// 3. Or else put the running sum and increment the count and return the final count

// Notes:  map.getOrDefault(rSum, 0) —> If not exists put the rSum and adds the value as 0, else the gets the value

import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum =0; 
        int cnt =0;
        for(int i=0; i< nums.length;i++){
            rSum= rSum + nums[i];
            if(map.containsKey(rSum-k))
                cnt+=map.get(rSum -k);
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return cnt;
    }
}