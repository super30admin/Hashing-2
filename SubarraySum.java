// Time Complexity : O(n)
// Space Complexity : O(n)

/*
 * Find the running sum and store it with its number of occurance.
 * if runningsum-k already exist we increment the result.
 */

import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            if(map.containsKey(runningSum - k)){
                res += map.get(runningSum - k);
            }
            if(!map.containsKey(runningSum)){
                map.put(runningSum, 1);
            }
            else{
                int curr = map.get(runningSum);
                curr ++;
                map.put(runningSum, curr);                
            }
        }
        return res;
    }
}
