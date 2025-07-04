class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return 0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int maxi=0,rsum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) rsum-=1;
            else rsum+=1;
            if(map.containsKey(rsum)){
                maxi=Math.max(maxi,i-map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }
        return maxi;

    }
}