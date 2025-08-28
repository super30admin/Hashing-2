package Prooblem2;
import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int max=0;
        int rSum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            if(nums[i]==1){
                rSum++;
            }
            else{
                rSum--;
            }
            if(map.containsKey(rSum)){
                max= Math.max(max,i- map.get(rSum));
            }
            else{
                map.put(rSum,i);
            }
        }
        return max;
        
    }
}