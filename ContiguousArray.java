// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;
class ContiguousArray {
    public int findMaxLength(int[] nums) {

        // Create a hashmap to store the running sum along with its index
        HashMap<Integer, Integer> map = new HashMap<>();

        int runningSum = 0; // Variable to keep track of the running sum

        int max = 0; // Variable to store the maximum length of a contiguous subarray

        map.put(0, -1); // Initialize the map with a running sum of 0 at index -1

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                runningSum -= 1;
            }

            else
            {
                runningSum += 1;
            }


            // Check if the current running sum is already present in the map
            if(map.containsKey(runningSum))
            {
                // If it exists, update the maximum length using the difference between the current index and the index stored in the map
                max = Math.max(max, i - map.get(runningSum));
            }

            else
            {
                // If it doesn't exist, store the current running sum along with its index in the map
                map.put(runningSum, i);
            }

        }

        return max; // Return the maximum length of a contiguous subarray with an equal number of 0s and 1s

    }
}