import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                rSum++;
            } else {
                rSum--;
            }
            if (map.containsKey(rSum)) {
                max = Integer.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}
