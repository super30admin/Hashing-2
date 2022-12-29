// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SubarraySumEqualTarget {
    public int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> complementMap = new HashMap<>();
        complementMap.put(0, 1);
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int currentComplement = runningSum - target;
            if (complementMap.containsKey(currentComplement)) {
                count += complementMap.get(currentComplement);
            }
            if (!complementMap.containsKey(runningSum)) {
                complementMap.put(runningSum, 1);
            } else {
                complementMap.put(runningSum, complementMap.get(runningSum) + 1);
            }
        }
        return count;
    }
}