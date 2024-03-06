// Time Complexity : O(n) number of characters in string
// Space Complexity : O(n) -
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We use a HashMap to store the running sum and its frequency, incrementing the result by the frequency of a running sum subtracted by the target
whenever it's found. Finally, it returns the total count of such subarrays.
 */
import java.util.HashMap;

public class SubArraySumEqualsK {

    public static int subArraySumK(int[] nums, int target) {
        int res = 0;
        int rsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // for the base case
        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            if (map.containsKey(rsum - target)) {
                res += map.get(rsum - target);
            }
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 3;
        System.out.println(subArraySumK(nums, target));
    }
}
