class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int rsum=0,count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rsum=rsum+nums[i];
            if(map.containsKey(rsum-k)){
                count=count+map.get(rsum-k);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,1);
            }
            else{
                map.put(rsum,map.get(rsum)+1);
            }
            
        }
        return count;
    }
}