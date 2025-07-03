//Time Complexity - O(n)
//Space Complexity - O(n)

// Implemented using a HashMap on a subArraySum with running sum and count variables updating at
// each index and added to the map.
import java.util.HashMap;

public class SubArray {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int rSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            if(map.containsKey(rSum - k)) {
                count = count + map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return count;
    }
}
