import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        if(nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)  sum = sum - 1;
            else sum = sum + 1;
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                max = Math.max(i-map.get(sum), max);
            }
        }
        return max;
    }
}
