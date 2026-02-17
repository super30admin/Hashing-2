class SubarraySum {
    // time complexity O(n)
    // space complexity O(n)
    // ran successfully in leetcode
    // the logic keeps track of the prevous count and sum of the subarray
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> previousCount = new HashMap<>();
        previousCount.put(0, 1); // base case, if a sum of 0 is required in the future count increments by one

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            // if the sum difference is already there then calculate the
            if (previousCount.containsKey(sum - k)) {
                count += previousCount.get(sum - k);
            }
            // update the count
            previousCount.put(sum, previousCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}