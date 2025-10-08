import java.util.HashMap;

/**
 * Leet Code : https://leetcode.com/problems/contiguous-array/submissions/1795059689/
 * This class provides a solution to the Contiguous Array problem from LeetCode.
 * It finds the maximum length of a contiguous subarray with equal number of 0s and 1s.
 */
public class ContiguousArray {

    /**
     * Finds the maximum length of a contiguous subarray with equal number of 0s and 1s.
     * Uses a running sum (rSum) and a HashMap to track the first occurrence of each rSum value.
     * If the same rSum is seen again, it means the subarray between the indices has equal 0s and 1s.
     */
    public int findMaxLength(int[] nums) {
        // HashMap to store the first occurrence of each running sum (rSum)
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0; // Stores the maximum length found
        int rSum = 0; // Running sum: +1 for 1, -1 for 0

        // Edge case: to handle subarrays starting from index 0
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Update running sum: -1 for 0, +1 for 1
            if (nums[i] == 0) rSum -= 1;
            else rSum += 1;
            // If rSum has been seen before, update max length
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }else {
                // Store the first occurrence of this rSum
                map.put(rSum, i);
            }
        }

        return max;
    }

}
