// Time Complexity: O(n), where n is the length of the nums array.
// Space Complexity: O(n), as the HashMap can store at most n + 1 distinct prefix sums.

// Approach: Use a HashMap to store the frequency of each prefix sum and initialize it with (0, 1) to handle subarrays starting from index 0.
// Iterate through the array, calculate the current prefix sum, and if prefixSum - k exists in the map, add its frequency to the counter.
// Update the frequency of the current prefix sum in the map and return the total count after iteration.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for(int n : nums){
            prefixSum += n;
            if(map.containsKey(prefixSum-k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
            
        }
        return count;
    }
}
