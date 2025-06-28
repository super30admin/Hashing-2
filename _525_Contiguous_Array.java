import java.util.HashMap;

public class _525_Contiguous_Array {
    public static void main(String[] args) {
        
    }

    public int findMaxLength(int[] nums) {

        if(nums == null || nums.length==0 || nums.length==1){
            return 0;
        }
        
        int ans = 0;
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<nums.length;i++){

            if(i == 0){
                sum -=1;
            }else{
                sum +=1;
            }
            
            if(map.containsKey(sum)){
               ans = Math.max(ans,map.get(sum)-i-1);
            }else{
                map.put(sum,i);
            }
        }

        return ans;
    }
}
