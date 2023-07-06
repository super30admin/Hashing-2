
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;

class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        // Create a hashmap to store the running sum along with its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize the hashmap with an entry for running sum 0
        map.put(0, 1);

        int count = 0; // Variable to keep track of the count of subarrays

        int runningSum = 0; // Variable to keep track of the running sum

        for(int i = 0; i < nums.length; i++)
        {
            runningSum += nums[i]; // Add the current element to the running sum
            int complement = runningSum - k; // Calculate the complement to check if there is a subarray with sum k

            // Check if there is a complement in the hashmap
            if(map.containsKey(complement))
            {
                count += map.get(complement); // Increment the count by the frequency of the complement sum
            }

            // Update the hashmap with the running sum and its frequency
            if(map.containsKey(runningSum))
            {
                map.put(runningSum, map.get(runningSum) + 1); // If the running sum exists, increment its frequency
            }

            else
            {
                map.put(runningSum, 1); // If the running sum doesn't exist, add it to the hashmap with frequency 1
            }
        }

        return count; // Return the total count of subarrays with sum k

    }
}