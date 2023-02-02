import java.util.HashMap;

public class Contiguous_array {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int rsum = 0;
        int max_length = 0;
        map.put(rsum,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                rsum+=1;
            }
            else{
                rsum-=1;
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,i);
            }
            else{
                int earliest_idx = i-map.get(rsum);
                max_length = Math.max(max_length,earliest_idx);
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        System.out.println(Contiguous_array.findMaxLength(new int[]{0,1,0,1}));
    }
}
