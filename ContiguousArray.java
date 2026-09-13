class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        store.put(0,-1);
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                prefixSum-=1;
            }else{
                prefixSum+=1;
            }
            if(store.containsKey(prefixSum)){
                result = Math.max(result, i - store.get(prefixSum));
            }else{
                store.put(prefixSum,i);
            }
        }
        return result;
    }
}