//Time Complexity - O(n)
//Space Complexity - O(n)

// Implemented using a HashMap on a contiguos array with running sum and max variables updating at
// each index and added the rSum and index to the map.
import java.util.HashMap;

public class ContiguosArray {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int rSum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                rSum = rSum -1;
            } else {
                rSum = rSum +1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;

    }
}
