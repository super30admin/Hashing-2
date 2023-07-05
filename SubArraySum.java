// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        int result = 0;
        int runningSum = 0;
        int counter = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++)
        {
            runningSum += nums[i];
            if(map.containsKey(runningSum - k))
                counter += map.get(runningSum-k);
            if(map.containsKey(runningSum))
                map.put(runningSum , map.get(runningSum)+1);
            else map.put(runningSum , 1);
        }
        return counter;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subarraySum(arr,3));
    }
}
