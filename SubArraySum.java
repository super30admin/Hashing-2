// Using RSum to calculate the sum at that Index
// Add a default entry in the map with [0, 1] to make sure if the comp(rSum -k) is 0 then the array until that elemnt will be 1 sub array
// if different between running sum to k is available in the map then a sub array is found
// insert element in the map based on running sum and counter
class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> rSumCounterMap = new HashMap<>();
        int rSum = 0;
        rSumCounterMap.put(0, 1);
        int count = 0;
        for(int i = 0; i< nums.length;i++) {
            rSum += nums[i];

            if(rSumCounterMap.containsKey(rSum - k)) {
                count += rSumCounterMap.get(rSum - k);
            }
            rSumCounterMap.merge(rSum, 1, Integer::sum);
        }
        return count;
    }
}