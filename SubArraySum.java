// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Problem solving was easy after learning the concept of Running sum pattern


// Your code here along with comments explaining your approach

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;

        // Initialize the map
        // Key - sum
        // value - Index in the array
        Map<Integer, Integer> map = new HashMap<>();

        // Handle the edge case when the sum - k = 0 :: when sum = k
        map.put(0, 1);

        // Calculate Running sum
        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            // If Map contains sum - k then it will give number of SubArray
            // Intuition -
            // we need to find occurances of sum = K.
            // If we find the previous subarray with sum - k..then from that index onwards till
            // the current index i the sum is k as running sum = (sum - k) + k
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            // Add the sum with index in the map
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }

}
