class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int[] prefixSum = new int[nums.length];
        Map<Integer, Integer> constMap = new HashMap<>();
        constMap.put(0, -1);
        constMap.put(1, 1);
        int res = 0;
        int prefixRes = 0;

        Map<Integer, Integer> rSumMap = new HashMap<>();
        rSumMap.put(0, -1);
        for(int i=0; i< nums.length; i++){
            prefixRes += constMap.get(nums[i]);
            prefixSum[i] = prefixRes;
            if(!rSumMap.containsKey(prefixRes))
                rSumMap.put(prefixRes, i);
            else{
                res = Math.max(res, i - rSumMap.get(prefixSum[i]));
            }
        }
    return res;
    }
}