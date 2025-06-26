// Time Complexity: O(n)
// Space Complexity: O(n)

// Use a HashMap to store runningSum along with frequencies
// Apply a two sum approach and get different kinds of subarrays that can reach the given sum of target k

class Solution {
    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        int rSum = 0;
        int count = 0;

        freqMap.put(0, 1); // 0 appears once before we start iterating

        for (int num : nums) {

            rSum = rSum + num;
            if (freqMap.containsKey(rSum - k)) {
                count = count + freqMap.get(rSum - k);
            }

            freqMap.put(rSum, freqMap.getOrDefault(rSum, 0) + 1);


        }

        return count;

    }
}
