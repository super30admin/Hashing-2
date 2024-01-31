import java.util.HashMap;

public class contiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        hMap.put(0,-1);
        int max =0;
        int rSum=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                rSum--;
            }
            else rSum++;
            if (hMap.containsKey(rSum)){
                max = Math.max(max, i-hMap.get(rSum));
            }else hMap.put(rSum,i);
        }
        return max;
    }
}
