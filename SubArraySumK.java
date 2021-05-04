class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        int rSum=0, count=0;
        if(nums.length==0 || nums==null) 
            return 0;
        // Hashmap to keep track of subarray sum and the count representing number of times it has happended
        // so that we can take this count and add it to final count 
        HashMap<Integer, Integer> subarraySumMap = new HashMap<>();
        // Add element to hashmap at index 0 as 1 to handle edge case
        subarraySumMap.put(0,1);
        for(int i=0;i<nums.length;i++) {
            // Calculate rSum by adding current element and previous rSum
            rSum = rSum + nums[i];
            // k = X - Y
            // If rSum - k is there in map that means the subarray has sum k
            if(subarraySumMap.containsKey(rSum - k)) {
                count += subarraySumMap.get(rSum - k);
            }
            // Add rSum in map and the count is previous count of rSum + 1
            subarraySumMap.put(rSum, subarraySumMap.getOrDefault(rSum,0)+1);
            
        }
        return count;
        
    }
}
