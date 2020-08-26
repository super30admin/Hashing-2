
import java.util.*;
public class contiguous_array_525 {
    public static void main(String args[]) {
        int arr[] = new int[] {1,0,1,1,1,1,0,0,1,0,1};
        int val = cont_array(arr);
        System.out.println(val);
    }

    public static int cont_array(int nums[]) {
        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum += 1;
            }else{
                sum -= 1;
            }
            
            if(sum == 0)
                max = i+1;
            
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }else{
                max = Math.max(max, i - hm.get(sum));
            }
        }
        return max;
    }
}
