// Time Complexity : O(n) number of characters in string
// Space Complexity : O(n) - worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We iterate through the array, updating the running sum based on the current element. If the sum is encountered again,
 we update the length of the longest subarray with equal 0s and 1s. Finally, we return the calculated length.
 */
import java.util.HashMap;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum -= 1;
            if (nums[i] == 1) sum += 1;
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1};
        System.out.println(findMaxLength(nums));
    }
}
