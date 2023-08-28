import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(ns)
public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 7, 2, -3, 1, 4, 2, 0, 1 };
        int target = 7;
        int result = subarraySum(arr, target);
        System.out.println(result);
    }

    /**
     * @param arr
     * @param target
     * @return total number of subarrays whose sum equals to target.
     */
    private static int subarraySum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int result = 0;
        map.put(runningSum, 1);
        for (int i = 0; i < arr.length; i++) {
            runningSum = runningSum + arr[i];
            if (map.containsKey(runningSum - target)) {
                result = result + map.get(runningSum - target);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return result;
    }

}
