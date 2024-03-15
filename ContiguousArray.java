// TC : O(n)
// SC : O(n)

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int rSum =0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rSum--;
            } else rSum++;
            
            if(map.containsKey(rSum)) {
                max = Math.max(max, i-map.get(rSum));
            } else map.put(rSum, i);
        }
        
        return max;
    }
}