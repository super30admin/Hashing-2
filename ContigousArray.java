class ContigousArray {
    /**
    Time Complexity - O(n)
    Space Complexity - O(n)
    Array elements between two indexes with same running sum are balanced
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        int max = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) {
                runningSum += -1;
            } else {
                runningSum += 1;
            }
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, i);
            } else {
                max = Math.max(max, i - map.get(runningSum) );
            }
        }
        return max;
    }
}
