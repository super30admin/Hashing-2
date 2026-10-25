// Time Complexity : O(n) because we traverse the array once
// Space Complexity : O(n) for the prefix sum HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use prefix sums and a HashMap to count how many times each running sum has appeared.
// If the current prefix sum is rSum, then any previous prefix sum equal to rSum - k forms a subarray with sum k.
// The HashMap stores frequencies of prefix sums so all valid subarrays can be counted efficiently.

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        int result = 0;

        // handle subarrays starting at index 0
        map.put(0, 1);

        for(int num : nums) {
            rSum += num;

            // count subarrays ending at current index
            if(map.containsKey(rSum - k)) {
                result += map.get(rSum - k);
            }

            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }
}