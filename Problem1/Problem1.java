package Problem1;
import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int rSum=0;
        int result=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rSum+=nums[i];
            int cmp= rSum-k;
            if(map.containsKey(cmp)){
                result+=map.get(cmp);
            }
            if(map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }
            else{
                map.put(rSum,1);
            }

        }
        return result;
        
    }
}