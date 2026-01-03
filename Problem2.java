import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null  || nums.length==0) return 0;
        HashMap<Integer, Integer> map=new HashMap<>();
        int max=0;
        int rsum=0; //runnung sum
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                //decrease running sum by 1 if 0 is enountered
                rsum -=1 ;
            }
            else{
                //increase running sum by 1 if 1 is enountered
                rsum += 1;
            }
            if(map.containsKey(rsum)){
                int curr=i-map.get(rsum);
                max= Math.max(max,curr);
            }
            else{
                map.put(rsum,i);
            }
        }
    return max;
        
    }
}