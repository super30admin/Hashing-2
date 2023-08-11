// Sc = O(1);
// TC = O(n)
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1 };

        int k = 2;

        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int obj1 = obj.sum(arr, k);
        System.out.println("value" + obj1);
    }

    public int sum(int[] nums, int k) {

        HashMap<Integer, Integer> Map = new HashMap<>();
        int count = 0;
        int rSum = 0;
        Map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            int comp = rSum - k;

            if (Map.containsKey(comp)) {
                count += Map.get(comp);
            }
            if (Map.containsKey(rSum)) {
                Map.put(rSum, Map.get(rSum) + 1);
            } else {
                Map.put(rSum, 1);
            }

        }
        return count;

    }

}