import java.util.*;

public class ContiguousArray {
    public int contiguousArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rSum = 0;
        int max = 0;

        for (int i=0; i<nums.length; i++){
            int currNum = nums[i];
            if (currNum == 0) rSum--;
            else rSum++;

            hm.put(0,-1);
            if (!hm.containsKey(rSum)) {
                hm.put(rSum,i);
            } else{
                max = Math.max(i - hm.get(rSum), max);
            }
        }
        return max;
    }
}
