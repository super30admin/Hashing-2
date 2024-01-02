import java.util.HashMap;
//TC On
//SC O(1)

class contiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap();
        hm.put(0,-1);
        int length=0;
        int rsum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rsum--;
            }else{
                rsum++;
            }
            if(hm.containsKey(rsum)){
                length=Math.max(length,i-hm.get(rsum));
            }
            else{
                hm.put(rsum,i);
            }
        }
        return length;
    }
}