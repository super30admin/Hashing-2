// Time Complexity : O(n), where n is the length of the input array
// Space Complexity : O(n), for storing running sums in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// runnin sum + HashMap approach:
// If the nums at that index is 0; than decrement the running sum else if its 1 then increment it.
// If the same rsum is seen again, it means the number of 0s and 1s between those indices is equal.
// We store the earliest index of each rsum in the map and calculate the maximum length of such subarrays.

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        int rsum =  0;

        // Map stores the first occurrence index of each running sum
        HashMap<Integer,Integer> map =  new HashMap<>();
        map.put(0,-1); // Initialize with 0 sum at index -1 for edge case

        for (int i = 0; i < n; i++) {
            // Compute running sum
            if(nums[i] == 0) rsum--;
            else rsum++;

            // If rsum is seen before, calculate the length of subarray with equal 0s and 1s
            if(map.containsKey(rsum)){
                max = Math.max(max, i - map.get(rsum));
            } else {
                // Store the first occurrence of rsum
                map.put(rsum, i);
            }
        }
        return max;
    }
}