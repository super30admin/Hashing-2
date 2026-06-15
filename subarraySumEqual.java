import java.util.*;

public class SubarraySumEqual {
    
    public boolean subarraySumEqual(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int runningSum = 0;
        map.put(0,1);
        for (int i=0; i<nums.length; i++){
            int curr = nums[i];
            runningSum += curr;
            if(map.containsKey(runningSum-k)){
                count += map.get(runningSum-k);
            } 
            if (map.containsKey(runningSum)){
                map.put(runningSum, map.get(runningSum)+1);

            } else {
                map.put(runningSum, 1);
            }
        }
        return count;
    }
}
