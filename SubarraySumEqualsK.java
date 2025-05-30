
import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sol = new SubarraySumEqualsK();

        int[] nums = {2, 3, -1, 5, 0, -9, 11};
        int k = 4;

        int result = sol.subarraySum(nums, k);
        System.out.println("Count of subarrays with sum " + k + " = " + result);
    }
}
