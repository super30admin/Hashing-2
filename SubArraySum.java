import java.util.HashMap;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            if (map.containsKey(rSum - k)) {
                count = count + map.get(rSum - k);
            }
            if (!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }
        return count;
    }
}
