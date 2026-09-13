class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> store = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        store.put(prefixSum,1);
        for(int i = 0; i<nums.length;i++){
            prefixSum+=nums[i];
            if(store.containsKey(prefixSum - k)){
                result += store.get(prefixSum - k);
            }
            if(!(store.containsKey(prefixSum))){
                store.put(prefixSum,1);
            }else{
                store.put(prefixSum,store.get(prefixSum)+1);
            }
        }
        return result;
    }
}