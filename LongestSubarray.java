import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(n) where n is the number of elements in the array
//Space Complexity: O(n) in worse case where the array has all 1s or 0s
//Did this code successfully run on Leetcode : Yes

/**
 * Using the hashing technique to keep the track of when the running sum was equal with 0->-1 and 1->1 mapping for sum.
 * When the sum was equal, the subarray was balanced. We do this for all elements and get the max difference between the current sum's index and the index where the sum was seen last.
 */
public class LongestSubarray {
    static int longestSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> sumByIndex = new HashMap<>();
        sumByIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            sum = sum + (nums[i] == 0 ? -1 : 1);
            if (sumByIndex.containsKey(sum)) {
                max = Math.max(max, i - sumByIndex.get(sum));
            } else
                sumByIndex.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}));
    }
}
