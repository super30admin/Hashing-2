// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: no
//Approach:
// 1. In order to find the sub array sum, instead of iterating the array, prefix sum is used
// 2. Use hashmap to store the prefix sum and its frequency
// 3. Check if the diff i.e prefix - target is present in hash map and add its frequency to the result count

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    // brute force approach
    // TC: O(n^3), SC: O(1)
    private static int subarraySumBruteForce(int[] nums, int k) {
        // brute force
        int n = nums.length, count = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int sum = 0;
                // sum of each subarray
                for(int idx=i; idx<=j; idx++) {
                    sum += nums[idx];
                }
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // optimized with prefix sum and hash table
    private static int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, prefixSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        for(int i=0; i<n; i++) {
            prefixSum += nums[i];

            // handles the case where the subarray is from idx 0 to i and sum equals k
            if(prefixSum == k) {
                count++;
            }
            // check if the diff of target from prefixSum has occured by checking hash map
            if(prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }
            // add the subarray sum value and its frequency in hash map
            prefixSumFreq.put(prefixSum,
                    prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(subarraySum(new int[]{1,2,3}, 3)); //2
    }
}
