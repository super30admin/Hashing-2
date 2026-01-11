import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //Create HashMap to store running sum & corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        int max = 0;
        map.put(0,-1); //create dummy entry in map to catch initial ssubarray
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum = rSum - 1;
            } else {
                rSum = rSum + 1;
            }
            if(map.containsKey(rSum)){
                int curr = i - map.get(rSum);
                max = Math.max(max, curr);
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}
