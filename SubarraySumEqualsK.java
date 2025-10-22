// Time Complexity : O(n) where n is the number of elements in the input array.
// Space Complexity : O(n) we might have to save all prefix sums in the map.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Subarray Sum Equals to K
 * */

/*
 * Approach: Running Sum and HashMap
 *
 * In this approach, we calculate the running sum for every element and add it to the map with its frequency.
 * We also compute the complement by deducting it from target, to check if the complement running sum has already occurred.
 * If it does, we can assume that the sum in between is equal to the target & we have found a subarray, and we can increment
 * the result by 1. We need to store the frequency because this will be true for all complements.
 * */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int rSum = 0;
        int result = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int i=0; i<n; i++) {
            rSum += nums[i];

            int complement = rSum - k;

            if (prefixSums.containsKey(complement)) {
                result += prefixSums.get(complement);
            }

            prefixSums.put(rSum, prefixSums.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 9;

        int[] nums2 = {1, 1, 1};
        int k2 = 2;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(nums1, k1));
        System.out.println(subarraySumEqualsK.subarraySum(nums2, k2));
    }
}
