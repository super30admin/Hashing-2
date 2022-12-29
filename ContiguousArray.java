// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        HashMap<Integer, Integer> runningSumMap = new HashMap<>();
        int runningSum = 0;
        int maxLength = 0;
        runningSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] == 1) {
                runningSum++;
            } else {
                runningSum--;
            }
            if (runningSumMap.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, i - runningSumMap.get(runningSum));
            } else {
                runningSumMap.put(runningSum, i);
            }
        }
        return maxLength;
    }
}