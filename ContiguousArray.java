class Solution {
    public int findMaxLength(int[] nums) {
        // Check if the input array is null or empty, return 0 if true
        if (nums == null || nums.length == 0)
            return 0;

        // Create a HashMap to store the running sum as the key and its index as the value
        HashMap<Integer, Integer> map = new HashMap<>();

        int runningSum = 0; // Initialize a variable to keep track of the running sum
        int max = 0; // Initialize a variable to store the maximum subarray length
        map.put(0, -1); // Initialize the map with a running sum of 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            // Update the running sum based on the current element (0 becomes -1, 1 remains 1)
            if (nums[i] == 0)
                runningSum -= 1;
            else
                runningSum += 1;

            // Check if the running sum has been seen before
            if (map.containsKey(runningSum)) {
                // Calculate the length of the subarray and update max if it's longer
                max = Math.max(max, i - map.get(runningSum));
            } else {
                // If the running sum is not in the map, add it with its current index
                map.put(runningSum, i);
            }
        }
        return max; // Return the maximum subarray length with an equal count of 0s and 1s
    }
}


//Time Complexity: O(N)
//Space Complexity: O(N)
