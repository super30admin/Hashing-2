// Brute Force:
// Time Complexity : faster than 14.61% Submissions
// Space Complexity : used space less than 96.34% submissions.

// class Solution {
// public int subarraySum(int[] nums, int k) {

// int counter = 0;
// // int initial = 0;

// for (int i = 0; i < nums.length; i++){
// int initial = nums[i];
// if (initial == k){
// counter = counter + 1;
// }
// for (int j = i+1; j < nums.length ; j++){
// initial = initial + nums[j];

// if (initial == k){
// counter = counter + 1;
// }
// }

// }

// return counter;
// }
// }

// Time Complexity : 54ms (faster than 53.29% sunmissions)
// Space Complexity : 66.5 MB (less than 66% submissions)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int cntr = 0;
        int prefixSum = 0;

        prefixSumMap.put(0, 1);

        for (int num : nums) {

            prefixSum += num;

            int excess = prefixSum - k;

            cntr += prefixSumMap.getOrDefault(excess, 0);

            prefixSumMap.put(
                    prefixSum,
                    prefixSumMap.getOrDefault(prefixSum, 0) + 1);

        }

        return cntr;

    }

}