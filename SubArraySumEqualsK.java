// Approach: Keep a hash map to store the runningSum as the key and the number of times this running sum occured during array traversal
// if rSum-k already occured, get the count corresponding to that rSum and add it to the existing count to get the number of subarrays with
// sum equal to k

// Time Complexity - O(n)
// Space Complexity - O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {

        // Validate the inputs
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int rSum = 0;
        map.put(0, 1);
        for(int num: nums)
        {
            rSum += num;
            count += map.getOrDefault(rSum-k, 0);
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return count;
    }
}