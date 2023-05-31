// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            // int num = map.getOrDefault(nums[i],0);
            if (map.containsKey(runningSum - k)) {
                ans += map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
            // Above line is replacement for this whole code below:
            // if(!map.containsKey (runningSum)){
            // map.put(runningSum,1);
            // }
            // else{
            // map.put(sum, map.get(runningSum)+1);
            // }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK obj = new SubArraySumEqualsK();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 1, 1, 1 };

        System.out.println("Total Number of SubArrays summing to 3: " + obj.subarraySum(nums1, 3));
        System.out.println("Total Number of SubArrays summing to 2: " + obj.subarraySum(nums2, 2));
        System.out.println("Total Number of SubArrays summing to 5: " + obj.subarraySum(nums2, 5));

    }
}