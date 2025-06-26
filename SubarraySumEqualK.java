/**
 * Given an array of integers nums and an integer k, return the number of continuous subarrays whose sum equals to k.
 * Approach: Using HashMap to store cumulative sums
 * - We maintain a cumulative sum and use a HashMap to store the frequency of each cumulative sum.
 * - For each element in the array, we update the cumulative sum and check if there exists a previous cumulative sum that would make the current subarray sum equal to k.
 * - If such a cumulative sum exists, we increment our count by the frequency of that cumulative sum.
 * - We also update the frequency of the current cumulative sum in the HashMap.
 * * Time Complexity: O(N) where N is the length of the input array.
 * * Space Complexity: O(N) for storing the cumulative sums in the HashMap.
 * 
 */
public class SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; // If the array is empty, return 0
        }

        Map<Integer, Integer> map = new HashMap<>(); // To store the cumulative sum and its frequency
        map.put(0, 1); // Initialize with sum 0 having one occurrence
        int count = 0; // To count the number of subarrays that sum to k
        int rSum = 0; // To keep track of the cumulative sum

        for (int num : nums) {
            rSum += num; // Update the cumulative sum

            // Check if there is a previous cumulative sum that would make the current subarray sum equal to k
            if (map.containsKey(rSum - k)) {
                count += map.get(rSum - k); // Increment count by the frequency of that previous sum
            }

            // Update the frequency of the current cumulative sum in the map
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return count; // Return the total count of subarrays that sum to k
    }
}
