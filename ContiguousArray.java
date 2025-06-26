/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * Approach:
 * 1. Use a HashMap to store the first occurrence of each count of 1s minus 0s.
 * 2. Traverse the array, incrementing the count for 1s and decrementing for 0s.
 * 3. If the count has been seen before, calculate the length of the subarray and update the maximum length.
 * 4. If the count has not been seen, store its index in the HashMap.
 * 
 * * Time Complexity: O(n) where n is the length of the input array.
 * * Space Complexity: O(n) for the HashMap.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with count 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            // Increment count for 1, decrement for 0
            count += (nums[i] == 1) ? 1 : -1;

            // Check if this count has been seen before
            if (map.containsKey(count)) {
                // Calculate the length of the subarray
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                // Store the first occurrence of this count
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
