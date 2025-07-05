/*525. Contiguous Array
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * 
 * 
 * 
 TimeComplexity:-O(n)
 SpaceComplexity:-O(n)
 Approach:- Whenever element at an index is 0 then we are subtracting 1 from running sum(rSum) and adding 1 to it when the element at an index is 1.Using a HashMap to store the first occurrence of each rSum and index.If the same rSum appears again, it means the subarray between those indices has a balanced number of 0s and 1s (i.e., net sum = 0).Only store the first time each rSum appears to ensure longest length.
 */

import java.util.HashMap;

class ContagiuousArray {
    public int findMaxLength(int[] nums) {
        // Edge case: empty or single-element array can't have balanced 0s and 1s
        if (nums.length == 0 || nums.length == 1 || nums == null) {
            return 0;
        }
        // HashMap to store (rSum → first index where it appeared)
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;// running sum
        int max = 0;// to track the maximum length found
        map.put(0, -1);// base case: sum = 0 seen before index 0
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current number is 0, treat it as -1 in rSum
            if (nums[i] == 0) {
                rSum = rSum - 1;
            } else {// If current number is 1, treat it as 1 in rSum
                rSum = rSum + 1;
            }
            // If this rSum has been seen before
            if (map.containsKey(rSum)) {
                // Length of balanced subarray between previous index and current index
                int length = i - map.get(rSum);
                // Update max if this subarray is longer
                max = Math.max(max, length);
            } else {// Store the first occurrence of this rSum
                map.put(rSum, i);
            }
        }
        // Return the maximum length of balanced subarray
        return max;
    }
}