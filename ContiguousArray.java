import java.util.HashMap;

class ContiguousArray {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // HashMap to store running sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int rSum = 0; // Running sum to keep track of cumulative sum
        int result = 0; // Number of valid subarrays
        
        // Base case: sum 0 appears once to handle the case when subarray starts from index 0
        map.put(0, 1);

        // Iterate over the array
        for (int num : nums) {
            rSum += num; // Add current element to running sum
            
            // Calculate the complement we are looking for
            int cmp = rSum - k;

            // If the complement exists in the map:
            // - It means there exists a subarray with sum equal to k
            if (map.containsKey(cmp)) {
                // Add the frequency of that complement to the result
                result += map.get(cmp);
            }

            // Update the frequency of the current running sum in the map
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        
        return result;
    }

}
