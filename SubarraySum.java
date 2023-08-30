import java.util.HashMap;

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // int[] runningSum = new int[nums.length];
        // instead of above thing we can use HashMap with key as running sum and value as frequency
        // TC: O(N); SC: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int subArrCount = 0;
        int runningSum = 0;
        map.put(0, 1); // Initial condition to maintain
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int complement = runningSum - k;
            if(map.containsKey(complement)) {
                subArrCount += map.get(complement);
            }
            if(map.containsKey(runningSum)) {
                map.put(runningSum, map.get(runningSum)+1);
            } else {
                map.put(runningSum, 1);
            }
        }
        return subArrCount;
    }
}