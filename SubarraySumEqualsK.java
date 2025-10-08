import java.util.HashMap;

/**
 * Leet Code : https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * This class provides a method to find the total number of continuous subarrays
 * whose sum equals to a given value k.
 *
 * Approach:
 * 1. Use a HashMap to store the cumulative (running) sum and its frequency.
 * 2. As we iterate through the array, keep a running sum (rSum) of elements so far.
 * 3. For each element, check if (rSum - k) exists in the map. If it does, it means there is a subarray ending at the current index whose sum is k.
 *    - Add the frequency of (rSum - k) to the count.
 * 4. Update the map with the current running sum.
 * 5. Initialize the map with (0, 1) to handle subarrays starting from index 0.
 *
 * This approach leverages prefix sums and a HashMap to count subarrays in a single pass, achieving O(n) time complexity.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // HashMap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0; // To store the result
        int rSum = 0;  // Running sum
        // Initialize with sum 0 occurring once
        map.put(0, 1);
        for (int num : nums) {
            rSum += num; // Update running sum
            int compliment = rSum - k; // Find the required sum to reach k
            // If compliment exists, add its frequency to count
            if (map.containsKey(compliment)) {
                count += map.get(compliment);
            }
            // Update the frequency of the running sum in the map
            if(!map.containsKey(rSum))
                map.put(rSum, 1);
            else
                map.put(rSum, map.get(rSum) + 1);
        }
        return count;
    }
}
