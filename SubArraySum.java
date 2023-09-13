class Solution {
    public int subarraySum(int[] nums, int k) {
        // Check if the input array is empty or null, return 0 if true
        if (nums == null || nums.length == 0)
            return 0;

        // Create a HashMap to store the running sum as the key and its frequency as the value
        HashMap<Integer, Integer> map = new HashMap<>();

        int runningSum = 0; // Initialize a variable to keep track of the running sum
        int count = 0; // Initialize a variable to count subarrays with a sum of k
        map.put(0, 1); // Initialize the map with a running sum of 0 and a frequency of 1

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i]; // Update the running sum

            // Check if (runningSum - k) is present in the map, indicating a subarray with sum k
            if (map.containsKey(runningSum - k)) {
                count += map.get(runningSum - k); // Increment the count with the frequency of (runningSum - k)
            }

            // Update the frequency of the current running sum in the map
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count; // Return the count of subarrays with a sum of k
    }
}

//Time Complexity: O(N)
//Space Complexity: O(N)
