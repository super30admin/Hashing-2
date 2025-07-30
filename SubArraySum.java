import java.util.HashMap;

public class SubArraySum {

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    //Did this code successfully run on Leetcode : Yes
    // This function returns the total number of subarrays that sum to k
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize map with sum 0 seen once
        map.put(0, 1);

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;

            // Check if runningSum - k has been seen before
            int diff = runningSum - k;
            if (map.containsKey(diff)) {
                count += map.get(diff); // Add frequency of that prefix sum
            }

            // Add or update current runningSum in the map
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySum solution = new SubArraySum();

        int[] nums = {1, 2, 3};  // Possible subarrays with sum 3: [1,2], [3]
        int k = 3;
        int result = solution.subarraySum(nums, k);
        System.out.println("Total subarrays with sum " + k + " = " + result); // Expected: 2

        int[] nums2 = {1, 1, 1};
        k = 2;
        System.out.println("Total subarrays with sum " + k + " = " + solution.subarraySum(nums2, k)); // Expected: 2

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        k = 7;
        System.out.println("Total subarrays with sum " + k + " = " + solution.subarraySum(nums3, k)); // Expected: 4
    }
}