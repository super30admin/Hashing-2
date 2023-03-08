class ContagiousArray {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum = sum + (-1);
            }
            else{
                sum = sum + nums[i];
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            else{
                int temp = i - map.get(sum);
                len = Math.max(len,temp);
            }
        }
            return len;
    }
}