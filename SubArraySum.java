/*this implementation uses Hashmap to find the sub arrays with sum k
* the time complexity for this implementation is O(n)*/
import java.util.*;

public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int runningSum = 0;
        for (int num : nums) {
            runningSum += num;
            if (prefixSum.containsKey(runningSum - k)) {
                count += prefixSum.get(runningSum - k);
            }
            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));  // Output: 2
    }
}
