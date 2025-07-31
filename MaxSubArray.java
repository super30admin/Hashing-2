class Solution {
    // This algorithm saves the running sum at each index. If at all a running sum is found as a new element, we store it and if it is reached again that means that is a balanced sub array with equal 1's and 0's
    public int findMaxLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) runningSum++;
            else runningSum--;
            // If same runningSUm is previously encountered, we can calculate the sub array length
            if(map.containsKey(runningSum)) {
                max = Math.max(max, i-map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}

