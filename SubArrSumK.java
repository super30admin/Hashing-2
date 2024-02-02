// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Understanding the logic itself. It is hard problem for me.

/*
1. Calculate Running Sum
2. See Running-K has happened before then add those many increments in to Count
3. Then add Running Sum in to Map
4. Return Count
*/

//Running Sum Pattern

import java.util.HashMap;
import java.util.Map;

public class SubArrSumK {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        if(nums == null || nums.length==0) return count;
        int runningSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1); //dummy entry for running 0 happens 1 time: To catch earlier SubArray with sumk

//        for (int num : nums) {
        for(int i =0; i< nums.length; i++) {
            runningSum += nums[i];

            if(map.containsKey(runningSum - k)){
                count+= map.get(runningSum - k);
            }

            if(map.containsKey(runningSum)){
                map.put(runningSum, map.get(runningSum)+1);
            }else{
                map.put(runningSum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArrSumK obj = new SubArrSumK();
//        System.out.println("Count =  "+ obj.subarraySum(new int[]{1,1,1}, 2));
        System.out.println("Count =  "+ obj.subarraySum(new int[]{1}, 0));
    }
}
