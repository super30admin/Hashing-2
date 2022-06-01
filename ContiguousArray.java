// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class ContiguousArray {

    // This is like longest sunstring with sum k
    // Here the k = 0 if we consider the 0 index occurance to be -1 for sum
    // If sum K = 0 we found our subarray
    public int findMaxLength(int[] nums) {

        int sum = 0;
        int k = 0;
        int maxi = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // we have to calculate the longest subarray
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) sum--;
            else sum++;

            if (sum == k) {
                // Handling the edge case
                maxi = i + 1;
            } else {

                // sum != k
                // Lets check if we have sum - k in our map
                if (map.containsKey(sum - k)) {
                    maxi = Math.max(maxi, i - map.get(sum - k));
                }

            }

            // Just put the first occurance of every sum with index
            // Because we have to calculate the longest subarray
            map.putIfAbsent(sum, i);

        }
        return maxi;
    }

}
