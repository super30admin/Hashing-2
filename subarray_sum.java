class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int rsum=0;
        int res=0;
        map.put(0,1);
        for(int num:nums){
            rsum+=num;
            int diff=rsum-k;
            if(map.containsKey(diff)){
                res+=map.get(diff);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
        }
        return res;
    }
}