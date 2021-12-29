class ContinuousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        int currentSum=0;
        int maxResult=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                currentSum--;
            }else{
                currentSum++;
            }
            
            if(map.containsKey(currentSum)){
                maxResult = Math.max(maxResult, i-map.get(currentSum) );
            }else{
                map.put(currentSum,i);
            }
        }
        
        return maxResult;
    }
}