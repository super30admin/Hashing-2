class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        Map<Integer,Integer> count = new HashMap();
        int result=0;
        count.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            
            if(count.containsKey(sum-k)){
                result += count.get(sum-k);
            }
            count.put(sum,count.getOrDefault(sum,0)+1);
            
        }
        
        return result;
    }
}