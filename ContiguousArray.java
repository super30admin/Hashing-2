import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0, rsum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                rsum += -1;
            } else {
                rsum += 1;
            }

            if (map.containsKey(rsum)) {
                max = Math.max(max, i - (map.get(rsum)));

            } else {
                map.put(rsum, i);
            }
        }
        return max;
    }
}
/**
 * Approach:
 * Replace 0s with -1s to convert the problem into finding the longest subarray with a sum of 0.
 * Compute running sum(rsum) as we traverse the array and if at 2 diff indices, rsum has the same value, then the subarray btw those indices has a sum of 0.
 * If rsum is seen before, compute the subarray length
 * If rsum is new, store its index
 * Update the max only if it's greater than the previous value.
 */

//TC: O(n) as we traverse through the array.
//SC: O(n) worst case to store n different sums.
